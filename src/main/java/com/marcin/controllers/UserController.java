package com.marcin.controllers;


import com.marcin.dto.RegisterUserDTO;
import com.marcin.dto.UserDTO;
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
        if (registerUserDTO.getId() == null) {
            if (result.hasErrors()) {
                List<ObjectError> errors = result.getAllErrors();
                for (ObjectError error : errors) {

                    log.info("Wystąpily błedy podczas wypełniania formularza {}", error);

                }

                return "addUserForm";
            }

            userFacade.registerNewUser(registerUserDTO);
            userFacade.sendCredentialsMail(registerUserDTO);

            log.info("Zapisano nowego usera {} wysłano mail na adres {}", registerUserDTO.getUsername(), registerUserDTO.getEmail());

        } else {
            userFacade.update(registerUserDTO);

            log.info("Udało sie zaktualizować dane usera o id {}", registerUserDTO.getId());
        }

        return "result-page";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Long id, Model model) {
        UserDTO userDTO = userFacade.getUserById(id);
        model.addAttribute("userDTO", userDTO);
        return "addUserForm";
    }

}



