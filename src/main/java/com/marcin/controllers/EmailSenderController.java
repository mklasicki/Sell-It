package com.marcin.controllers;

import com.marcin.domain.EmailSender;
import com.marcin.mailSender.EmailConfig;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class EmailSenderController {

    private EmailConfig emailConfig;

    public EmailSenderController(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }

    @PostMapping("/sendMail")
    public void sentMail(@RequestBody EmailSender emailSender, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("Data is not valid");
        }
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailConfig.getHost());
        mailSender.setPort(emailConfig.getPort());
        mailSender.setUsername(emailConfig.getUsername());
        mailSender.setPassword(emailConfig.getPassword());

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("klasicki@gmail.com");
        mailMessage.setSubject("First message from " + emailSender.getName());
        mailMessage.setText(emailSender.getBody());

        mailSender.send(mailMessage);

    }


}

