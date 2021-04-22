package com.marcin.controllers;


import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


import java.util.Arrays;
import java.util.List;


import com.marcin.domain.Category;
import com.marcin.domain.Product;
import com.marcin.dto.ProductDTO;
import com.marcin.facades.CategoryFacade;
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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;



@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ProductFacade productFacade;

    @MockBean
    CategoryFacade categoryFacade;

    @MockBean
    UserDetailsServiceImpl userDetailsService;

    @MockBean
    StorageServiceImpl storageService;

    @InjectMocks
    ProductController productController;

    @Test
    @WithMockUser(username = "Mar", password = "pass")
    void shouldReturnOkStatusWhenUserIsLoggedIn() throws Exception {

        //given
        String url = "/product/product-form";

        //when
        when(categoryFacade.getAllCategories()).thenReturn(generateCategoryList());

        //then
        mockMvc.perform(MockMvcRequestBuilders.get(url))
            .andExpect(status().isOk())
            .andDo(print())
            .andExpect(view().name("product-form"))
            .andExpect(model().attribute("categories",generateCategoryList()))
            .andExpect(model().attribute("product", new ProductDTO()));

        verify(categoryFacade, times(1)).getAllCategories();
        verifyNoMoreInteractions(categoryFacade);
    }

    @Test
    void shouldReturnRedirectStatusWhenUserIsNotLoggedIn() throws Exception {

        //given
        String url = "/product/product-form";

        //then
        mockMvc.perform(MockMvcRequestBuilders.get(url))
            .andExpect(status().is3xxRedirection())
            .andDo(print())
            .andExpect(redirectedUrl("http://localhost/login"))
            .andReturn();

        verify(categoryFacade,never()).getAllCategories();
    }

    @Test
    void saveProduct() throws Exception {

        //given
//        when(productFacade.validateAndRegisterNewProduct(any(ProductDTO.class),any(BindingResult.class), any(Principal.class)))
//            .thenReturn(anyString());

        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/product/save"))
                .andExpect(status().is2xxSuccessful()).andDo(print());

    }

    @Test
    void showFormForDelete() {
    }

    @Test
    void shouldReturnOkStatusWhenUrlIsCorrect() throws Exception {

        //given
        String categoryName = "Elektronika";
        String url = "/product/" + categoryName;

        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("category"));
    }

    @Test
    void shouldReturnNotFoundStatusWhenUrlIsIncorrect() throws Exception {

        //given
        String categoryName = "Elektronika/4";
        String url = "/product/" + categoryName;

        //when
        //then
        mockMvc
            .perform(MockMvcRequestBuilders.get(url))
            .andExpect(status().isNotFound())
            .andDo(print());
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