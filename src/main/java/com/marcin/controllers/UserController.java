package com.marcin.controllers;


import com.marcin.converters.Converter;
import com.marcin.domain.User;
import com.marcin.dto.UserDTO;
import com.marcin.facades.UserFacade;
import com.marcin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private final UserService userService;
    private final Converter<UserDTO, User> converter;
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    public UserController(UserFacade userFacade, UserService userService, @Qualifier("userConverterImpl") Converter<UserDTO, User> converter) {
        this.userFacade = userFacade;
        this.userService = userService;
        this.converter = converter;
    }

    @GetMapping("/register")
    public String registerUser(@ModelAttribute("UserDTO") UserDTO userDTO) {
        return "register-user-form";
    }

    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("UserDTO") UserDTO userDTO, BindingResult result) throws MessagingException {
        return checkAndRegisterNewUser(userDTO, result);
    }

    @GetMapping("/updateUserForm")
    public String showUpdateForm(@RequestParam("userId") Long id, Model model) throws IOException {
        UserDTO userDTO = converter.from(userService.findById(id).orElse(null));
        model.addAttribute("userDTO", userDTO);
        return "update-user-form";
    }

    @PostMapping("/update")
    public String update(Long id, UserDTO userDTO) {
        userService.updateUser(id,userDTO);
        return "my-page";
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



