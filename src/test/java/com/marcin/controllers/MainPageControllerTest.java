package com.marcin.controllers;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import com.marcin.facades.ProductFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

@ExtendWith(MockitoExtension.class)
class MainPageControllerTest {

    @Mock
    ProductFacade productFacade;

    @Mock
    Model model;

    @InjectMocks
    MainPageController mainPageController;


    @Test
    void getProducts() throws IOException {

        String viewName = mainPageController.getProducts(model);

        assertEquals("main", viewName);
        verify(productFacade, times(1)).getAll();
        verify(model, times(1)).addAttribute(eq("products"), anyList());

    }
}