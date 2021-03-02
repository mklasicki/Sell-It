package com.marcin.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    private final Logger log = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/login")
    public String loginForm() {
        log.info("[LoginController]: Opening login page");
        return "login-form";
    }
}
