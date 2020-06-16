package com.marcin.controllers;


import com.marcin.dto.UserDTO;
import com.marcin.facades.UserFacade;
import com.marcin.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserFacade userFacade;
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    public UserController(UserFacade userFacade, MailService mailService) {
        this.userFacade = userFacade;
    }

    @GetMapping("/register")
    public String showFormForAddUser(@ModelAttribute("userDTO") UserDTO userDTO) {
        return "addUserForm";
    }

    @PostMapping("/save")
    public String saveClient(@Valid @ModelAttribute("userDTO") UserDTO userDTO, BindingResult result) throws MessagingException {
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors) {

                log.info("Wystąpily błedy podczas wypełniania formularza {}", error);

            }

            return "addUserForm";
        }

        userFacade.registerNewUser(userDTO);
        userFacade.sendCredentialsMail(userDTO);

        log.info("Zapisano nowego usera {} wysłano mail na adres {}", userDTO.getUsername(), userDTO.getEmail());

        return "result-page";
    }

}


