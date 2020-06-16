package com.marcin.controllers;


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
    public String showFormForAddUser(@ModelAttribute("userDTO") UserDTO userDTO) {
        return "addUserForm";
    }

    @PostMapping("/save")
    public String saveClient(@Valid @ModelAttribute("userDTO") UserDTO userDTO, BindingResult result) throws MessagingException {
        if (userDTO.getId() == null) {
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

        } else {
            userFacade.update(userDTO);

            log.info("Udało sie zaktualizować dane usera o id", userDTO.getId());
        }

        return "result-page";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") String id, Model model) {
        UserDTO userDTO = userFacade.getUserById(Long.parseLong(id));
        model.addAttribute("userDTO", userDTO);
        return "addUserForm";
    }

}



