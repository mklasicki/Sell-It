package com.marcin.controllers;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


import com.marcin.service.impl.StorageServiceImpl;
import com.marcin.service.impl.UserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@WebMvcTest(LoginController.class)
class LoginControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserDetailsServiceImpl userDetailsService;

    @MockBean
    StorageServiceImpl storageService;

    @InjectMocks
    LoginController loginController;

    @Test
    void shouldReturnLoginPage() throws Exception {

        //given
        String url = "/login";

        //then
        mockMvc.perform(MockMvcRequestBuilders.get(url))
            .andExpect(status().isOk())
            .andDo(print())
            .andExpect(view().name("login"))
            .andExpect(forwardedUrl("/WEB-INF/view/tiles/layouts/defaultLayout.jsp"));
    }
}