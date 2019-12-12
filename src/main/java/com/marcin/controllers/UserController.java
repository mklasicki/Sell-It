package com.marcin.controllers;

import com.marcin.domain.User;
import com.marcin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/showFormForAddUser")
    public String showFormForAddUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUserForm";
    }

    @PostMapping("/saveUser")
    public String saveClient(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "addUserForm";
        } else {
            userService.saveUser(user);
            System.out.println("Zapisano nowego usera");
            return "redirect:/main";
        }

    }
}
