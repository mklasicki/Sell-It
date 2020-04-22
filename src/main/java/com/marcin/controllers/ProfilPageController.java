package com.marcin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfilPageController {

    @GetMapping("myPage")
    public String myPage() {
        return "my-page";
    }

}
