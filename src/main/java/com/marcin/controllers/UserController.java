package com.marcin.controllers;


import com.marcin.domain.User;
import com.marcin.dto.RegisterUserDTO;
import com.marcin.facades.UserFacade;
import com.marcin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    UserService userService;
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    public UserController(UserFacade userFacade, UserService userService) {
        this.userFacade = userFacade;
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerForm(@ModelAttribute("registerUserDTO") RegisterUserDTO registerUserDTO) {
        return "register-user-form";
    }

    @PostMapping("/save")
    public String saveClient(@Valid @ModelAttribute("registerUserDTO") RegisterUserDTO registerUserDTO, BindingResult result) throws MessagingException {
        // this will occur when there will be errors while filling register form
        if (result.hasErrors()) {
           showErrors(result);
            return "register-user-form";
        }

        userFacade.registerNewUser(registerUserDTO);
        userFacade.sendCredentialsMail(registerUserDTO);

        log.info("created new user {} sent email on address {}", registerUserDTO.getUsername(), registerUserDTO.getEmail());

        return "register-success-page";
    }

    private void showErrors(BindingResult result) {
        List<ObjectError> errors = result.getAllErrors();
        for (ObjectError error : errors) {
            log.info("Error during filling form {}", error);
        }
    }

}



