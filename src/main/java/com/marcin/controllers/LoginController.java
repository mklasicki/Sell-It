package com.marcin.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class LoginController {

    private final Logger log = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String loginForm() {
        log.info("[LoginController]: Opening login page");
        return "login";
    }
}
