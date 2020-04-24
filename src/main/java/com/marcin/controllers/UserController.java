package com.marcin.controllers;


import com.marcin.dto.RegisterUserDTO;
import com.marcin.facades.UserFacade;
import com.marcin.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import javax.validation.Valid;


@Controller
public class UserController {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserFacade userFacade;

    public UserController(UserService userService
            , BCryptPasswordEncoder bCryptPasswordEncoder
            , UserFacade userFacade) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userFacade = userFacade;
       }

    @GetMapping("/showFormForAddUser")
    public String showFormForAddUser(Model model) {
        RegisterUserDTO registerUserDTO = new RegisterUserDTO();
        model.addAttribute("user", registerUserDTO);
        return "addUserForm";
    }

    @PostMapping("/saveUser")
    public String saveClient(@Valid @ModelAttribute("user") RegisterUserDTO registerUserDTO) {
            String newPassword = bCryptPasswordEncoder.encode(registerUserDTO.getPassword());
            registerUserDTO.setPassword(newPassword);
            userFacade.registerNewUser(registerUserDTO);
            return "redirect:/main";
        }
    }


