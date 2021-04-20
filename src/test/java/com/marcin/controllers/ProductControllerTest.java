package com.marcin.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.marcin.facades.CategoryFacade;
import com.marcin.facades.ProductFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.Model;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    ProductFacade productFacade;

    @Mock
    CategoryFacade categoryFacade;

    @Mock
    Model model;

    @InjectMocks
    ProductController productController;

    @Test
    @WithMockUser(username = "Mar", password = "pass")
    void should_return_product_form_page() throws Exception {

        //given
        String viewName = productController.showProduct(model);

        mockMvc.perform(MockMvcRequestBuilders.get("/product/product-form"))
            .andExpect(status().isOk());



    }

    @Test
    void saveProduct() {
    }

    @Test
    void showFormForDelete() {
    }

    @Test
    void showProductsByCategory() {
    }

    @Test
    void search() {
    }
}