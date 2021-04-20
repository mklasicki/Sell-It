package com.marcin.controllers;

import static org.hibernate.criterion.Restrictions.eq;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


import java.util.Arrays;
import java.util.List;

import com.marcin.domain.Category;
import com.marcin.dto.ProductDTO;
import com.marcin.facades.CategoryFacade;
import com.marcin.facades.ProductFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
    void should_return_httpStatus200_when_user_is_authorized() throws Exception {

        when(categoryFacade.getAllCategories()).thenReturn(generateCategoryList());

        mockMvc.perform(MockMvcRequestBuilders.get("/product/product-form"))
            .andExpect(status().isOk()).andDo(print())
            .andExpect(view().name("product-form"))
            .andExpect(forwardedUrl("/WEB-INF/view/tiles/layouts/defaultLayout.jsp"))
            .andExpect(model().attribute("categories", categoryFacade.getAllCategories()))
            .andExpect(model().attribute("product", new ProductDTO()));
    }

    @Test
    void should_return_httpStatus302_and_redirect_to_login_page_when_user_is_not_authorized() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/product/product-form"))
            .andExpect(status().is3xxRedirection()).andDo(print())
            .andExpect(redirectedUrl("http://localhost/login"))
            .andReturn();

    }

    @Test
    void saveProduct() {
    }

    @Test
    void showFormForDelete() {
    }

    @Test
    void should_return_httpStatus200_with_correct_url_param() throws Exception {

        String param = "Elektronika";

        mockMvc.perform(MockMvcRequestBuilders.get("/product/" + param))
                .andExpect(status().isOk()).andDo(print())
                .andExpect(view().name("category"));
    }

    @Test
    void should_return_httpStatus404_with_incorrect_url_param() throws Exception {

        String param = "Elektronika/4";

        mockMvc
            .perform(MockMvcRequestBuilders.get("/product/" + param))
            .andExpect(status().is4xxClientError()).andDo(print());
    }

    @Test
    void should_return_httpStatus_200_with_correct_url_param() throws Exception {

        String param = "Rower";

        mockMvc
            .perform(MockMvcRequestBuilders.get("/product/search").param("productName", param))
            .andExpect(status().isOk()).andDo(print());
    }

    private List<Category> generateCategoryList() {
        Category cat1 = new Category(1L,"Elektronika",true, "/resources/images/electronics.png");
        Category cat2 = new Category(2L,"Nieruchomosci",true, "/resources/images/real-estate.png");
        Category cat3 = new Category(3L,"Motoryzacja",true, "/resources/images/cars.png");
        Category cat4 = new Category(4L,"Dom i Ogród",true, "/resources/images/house.png");
        Category cat5 = new Category(5L,"Sport",true, "/resources/images/electronics.png");
       return Arrays.asList(cat1, cat2, cat3, cat4 ,cat5);

    }

}