package com.marcin.controllers;


import com.marcin.dto.UserDTO;
import com.marcin.facades.UserFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserFacade userFacade;
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping("/register")
    public String registerUser(@ModelAttribute("UserDTO") UserDTO userDTO) {
        return "register-user-form";
    }

    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("UserDTO") UserDTO userDTO, BindingResult result) throws MessagingException {
        return checkAndRegisterNewUser(userDTO, result);
    }


    private String checkAndRegisterNewUser(UserDTO userDTO, BindingResult result) throws MessagingException {
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors) {

                log.info("Can't  register new user, errors occurred during filling form {}", error);
            }
            return "register-user-form";
        } else {
            userFacade.registerNewUser(userDTO);
            userFacade.sendCredentialsMail(userDTO);

            log.info("created new user {} sent email on address {}", userDTO.getUsername(), userDTO.getEmail());

            return "register-success-page";
        }
    }
}



