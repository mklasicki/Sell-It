package com.marcin.controllers;

import static org.hibernate.criterion.Restrictions.eq;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
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
        when(categoryFacade.getAllCategories()).thenReturn(generateCategoryList());
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/product/product-form"))
            .andExpect(status().isOk()).andDo(print())
            .andExpect(view().name("product-form"))
            .andExpect(forwardedUrl("/WEB-INF/view/tiles/layouts/defaultLayout.jsp"))
            .andExpect(model().attribute("categories", categoryFacade.getAllCategories()))
            .andExpect(model().attribute("product", new ProductDTO()));

        //then
        assertEquals("product-form", viewName);
        verify(categoryFacade, times(1)).getAllCategories();
    }

    @Test
    void should_return_login_form_page() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/product/product-form"))
            .andExpect(status().is3xxRedirection()).andDo(print());

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

    private List<Category> generateCategoryList() {
        Category cat1 = new Category(1L,"Elektronika",true, "/resources/images/electronics.png");
        Category cat2 = new Category(2L,"Nieruchomosci",true, "/resources/images/real-estate.png");
        Category cat3 = new Category(3L,"Motoryzacja",true, "/resources/images/cars.png");
        Category cat4 = new Category(4L,"Dom i Ogród",true, "/resources/images/house.png");
        Category cat5 = new Category(5L,"Sport",true, "/resources/images/electronics.png");
       return Arrays.asList(cat1, cat2, cat3, cat4 ,cat5);

    }

}