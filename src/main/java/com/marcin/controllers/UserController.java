package com.marcin.controllers;


import com.marcin.dto.UserDTO;
import com.marcin.facades.UserFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;


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
        return userFacade.validateAndRegisterNewUser(userDTO, result);
    }

    @GetMapping("/update-form")
    public String showUpdateForm(@RequestParam("userId") Long id, Model model) throws IOException {
        model.addAttribute("userDTO", userFacade.fillUserUpdateForm(id));
        return "update-user-form";
    }

    @PostMapping("/update")
    public String update(Long id, UserDTO userDTO) {
       userFacade.updateUser(id, userDTO);
        return "my-page";
    }

}



