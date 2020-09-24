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
    public String registerForm(@ModelAttribute("UserDTO") UserDTO userDTO) {
        return "register-user-form";
    }

    @PostMapping("/save")
    public String saveClient(@Valid @ModelAttribute("UserDTO") UserDTO userDTO, BindingResult result) throws MessagingException {

        if (result.hasErrors()) {
            showErrors(result);
            return "register-user-form";
        }

        registerNewUser(userDTO);
        return "register-success-page";
    }

    private void showErrors(BindingResult result) {
        List<ObjectError> errors = result.getAllErrors();
        for (ObjectError error : errors) {

            log.info("Error during filling form {}", error);
        }
    }

    private void registerNewUser(UserDTO userDTO) throws MessagingException {
        userFacade.registerNewUser(userDTO);
        userFacade.sendCredentialsMail(userDTO);

        log.info("created new user {} sent email on address {}", userDTO.getUsername(), userDTO.getEmail());
    }

}



