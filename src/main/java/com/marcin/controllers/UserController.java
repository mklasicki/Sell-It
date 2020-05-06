package com.marcin.controllers;


import com.marcin.dto.UserDTO;
import com.marcin.facades.UserFacade;
import com.marcin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    private final UserService userService;
    private final UserFacade userFacade;

    public UserController(UserService userService, UserFacade userFacade) {
        this.userService = userService;
        this.userFacade = userFacade;
       }

    @GetMapping("/showFormForAddUser")
    public String showFormForAddUser(@ModelAttribute("userDTO") UserDTO userDTO) {
        return "addUserForm";
    }

    @PostMapping("/saveUser")
    public String saveClient(@ModelAttribute("userDTO") UserDTO userDTO) {
            userFacade.registerNewUser(userDTO);
            return "redirect:/main";
        }
    }


