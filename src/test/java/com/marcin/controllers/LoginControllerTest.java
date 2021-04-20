package com.marcin.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class LoginControllerTest {

 @Autowired
 MockMvc mockMvc;

 @InjectMocks
 LoginController loginController;

 @Test
 void should_return_login_page() throws Exception {

     //given
     //when
     String viewName = loginController.loginForm();

     mockMvc.perform(MockMvcRequestBuilders.get("/login"))
         .andExpect(status().isOk())
         .andExpect(MockMvcResultMatchers.view().name("login"));

     //then
     assertEquals("login", viewName);
 }

}