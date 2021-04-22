package com.marcin.controllers;


import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.Collections;
import java.util.List;


import com.marcin.dto.ProductDTO;
import com.marcin.facades.ProductFacade;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.Model;


@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@WebMvcTest(MainPageController.class)
class MainPageControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductFacade productFacade;

    @MockBean
    UserDetailsServiceImpl userDetailsService;

    @MockBean
    StorageServiceImpl storageService;

    @MockBean
    Model model;

    @InjectMocks
    MainPageController mainPageController;


    @Test
    void shouldReturnMainPage() throws Exception {

        //given
        //when
        String url = "/main";
        List<ProductDTO> products = Collections.singletonList(new ProductDTO());
        when(productFacade.getAll()).thenReturn(products);

        //then
        mockMvc.perform(MockMvcRequestBuilders.get(url))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.model().attribute("products", products))
            .andExpect(MockMvcResultMatchers.model().attribute("products", hasSize(1)))
            .andExpect(MockMvcResultMatchers.view().name("index"))
            .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/view/tiles/layouts/defaultLayout.jsp"));

        verify(productFacade, times(1)).getAll();
    }
}