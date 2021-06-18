package com.marcin.controllers;


import com.marcin.dto.UserDTO;
import com.marcin.facades.UserFacade;
import com.marcin.util.ReCaptchaResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserFacade userFacade;

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public String registerUser(@ModelAttribute("UserDTO") UserDTO userDTO) {
        return "user-form";
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveUser(@Valid @ModelAttribute("UserDTO") UserDTO userDTO
        , @RequestParam(value = "g-recaptcha-response") String captchaResp
        , BindingResult result) throws MessagingException {
        RestTemplate restTemplate = new RestTemplate();
        String rUrl = "https://www.google.com/recaptcha/api/siteverify";
        String params = "?secret=6LdW-y4bAAAAADl0fQhKqTmErWNFz7G_go1FEz5-&response=" + captchaResp;

        ReCaptchaResponse response = restTemplate.exchange(rUrl + params, HttpMethod.POST
            , null, ReCaptchaResponse.class).getBody();
        System.out.println("Response ->" + response.isSuccess());

        if (response.isSuccess()) {
            return userFacade.validateAndRegisterNewUser(userDTO, result);
        } else {
            System.out.println("Recaptcha error");

            return "redirect:user-form";
        }
    }

    @GetMapping("/update-form")
    @ResponseStatus(HttpStatus.OK)
    public String showUpdateForm(@RequestParam("userId") Long id, Model model) throws IOException {
        model.addAttribute("UserDTO", userFacade.fillUserUpdateForm(id));
        return "user-form";
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String update(Long id, UserDTO userDTO) {
        userFacade.updateUser(id, userDTO);
        return "redirect:/my-page";
    }

}



