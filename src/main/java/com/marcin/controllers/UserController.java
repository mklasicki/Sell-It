package com.marcin.controllers;


import com.marcin.dto.UserDTO;
import com.marcin.facades.UserFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;


@Controller
public class UserController {

    private final UserFacade userFacade;
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
       }

    @GetMapping("/showFormForAddUser")
    public String showFormForAddUser(@ModelAttribute("userDTO") UserDTO userDTO) {
        return "addUserForm";
    }

    @PostMapping("/saveUser")
    public String saveClient(@Valid @ModelAttribute("userDTO") UserDTO userDTO, BindingResult result) {
            if(result.hasErrors()) {
                List<ObjectError> errors = result.getAllErrors();
                for(ObjectError error : errors) {

                    log.info("Wystąpily błedy podczas wypełniania formularza {}", error);

                }

                return "addUserForm";
            }

            userFacade.registerNewUser(userDTO);
            return "redirect:/main";
        }
    }


