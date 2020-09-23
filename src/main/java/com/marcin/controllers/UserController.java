package com.marcin.controllers;


import com.marcin.dto.RegisterUserDTO;
import com.marcin.facades.UserFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
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
    public String showFormForAddUser(@ModelAttribute("registerUserDTO") RegisterUserDTO registerUserDTO) {
        return "register-user-form";
    }

    @PostMapping("/save")
    public String saveClient(@Valid @ModelAttribute("registerUserDTO") RegisterUserDTO registerUserDTO, BindingResult result) throws MessagingException {
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors) {

                log.info("Error during filling form {}", error);

            }

            return "register-user-form";
        }

        userFacade.registerNewUser(registerUserDTO);
        userFacade.sendCredentialsMail(registerUserDTO);

        log.info("created new user {} sent email on address {}", registerUserDTO.getUsername(), registerUserDTO.getEmail());

        return "register-success-page";

    }

    @GetMapping("/update")
    public String update(Model model, Principal principal) throws IOException {
        String name = principal.getName();
        RegisterUserDTO registerUserDTO = userFacade.findUserByName(name);
        model.addAttribute("updateUserDTO", registerUserDTO);
        return "update-user-form";
    }

    @PostMapping("/updateUser")
    public String updateUser(RegisterUserDTO registerUserDTO) {
        userFacade.update(registerUserDTO);
        log.info("User with id {} has been updated", registerUserDTO.getId());
        return "update-success-page";
    }
}



