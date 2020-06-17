package com.marcin.controllers;


import com.marcin.dto.RegisterUserDTO;
import com.marcin.dto.UpdateUserDTO;
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

                log.info("Wystąpily błedy podczas wypełniania formularza {}", error);

            }

            return "register-user-form";
        }

        userFacade.registerNewUser(registerUserDTO);
        userFacade.sendCredentialsMail(registerUserDTO);

        log.info("Zapisano nowego usera {} wysłano mail na adres {}", registerUserDTO.getUsername(), registerUserDTO.getEmail());

        return "register-success-page";

    }


    @GetMapping("/update")
    public String update(Model model) {
        UpdateUserDTO updateUserDTO = new UpdateUserDTO();
        updateUserDTO.setUsername("Marcin");
        updateUserDTO.setSurname("Klasicki");
        updateUserDTO.setEmail("jakiś@wp.pl");
        model.addAttribute("updateUserDTO", updateUserDTO);
        return "update-user-form";
    }

    @PostMapping("/updateUser")
    public String updateUser() {

        return "update-success-page";
    }
}

/*
 userFacade.update(registerUserDTO);

 log.info("Udało sie zaktualizować dane usera o id {}", registerUserDTO.getId());

 */

