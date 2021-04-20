package com.marcin.controllers;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import com.marcin.domain.Product;
import com.marcin.facades.ProductFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.Model;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class MainPageControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    ProductFacade productFacade;

    @Mock
    Model model;

    @InjectMocks
    MainPageController mainPageController;


    @Test
    void getProducts() throws Exception {

        //given
        //when
        String viewName = mainPageController.getProducts(model);
        productFacade.getAll();

        mockMvc.perform(MockMvcRequestBuilders.get("/main")).andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.view().name("index"));

        //then
        assertEquals("index", viewName);
        verify(productFacade, times(1)).getAll();
        verify(model, times(1)).addAttribute(eq("products"), anyList());

    }
}