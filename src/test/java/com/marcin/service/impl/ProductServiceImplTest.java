package com.marcin.service.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import com.marcin.domain.Category;
import com.marcin.domain.Product;
import com.marcin.domain.User;
import com.marcin.exceptions.EmptySearchFormFieldException;
import com.marcin.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;

    @Test
    void shouldReturnListOfAllProducts() {

        //given
        when(productRepository.findAll()).thenReturn(generateTestData());

        //when
        List<Product> allProducts = productService.getAll();

        //then
        assertThat(allProducts, hasSize(2));
        assertThat(allProducts, is(not(empty())));
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void findProductByName() {


    }

    @Test
    void shouldThrowEmptySearchFormExceptionWhenProductNameIsNull() {

        assertThrows(EmptySearchFormFieldException.class, () -> productService.findProductByName(null));

    }

    @Test
    void shouldThrowEmptySearchFormExceptionWhenProductNameIsEmptyString() {

        //given
        String productName = "";

        assertThrows(EmptySearchFormFieldException.class, ()-> productService.findProductByName(productName));
    }

    @Test
    void shouldRegisterNewProduct() {

        //given
        Product product = Product.builder().id(1L).build();
        when(productRepository.save(product)).thenReturn(product);
        ArgumentCaptor<Product> argumentCaptor = ArgumentCaptor.forClass(Product.class);

        //when
        productRepository.save(product);

        //then
        verify(productRepository).save(argumentCaptor.capture());
        Product addedProduct = argumentCaptor.getValue();
        assertThat(addedProduct, is(product));
        verify(productRepository, times(1)).save(ArgumentMatchers.any());
    }

    @Test
    void getProductsByUserId() {
    }

    @Test
    void getProductsByCategory() {

        //given
        String categoryName = "sport";
        Category category = new Category();
        category.setName(categoryName);
        Product product1 = Product.builder().id(1L).category(category).build();
        Product product2 = Product.builder().id(2L).build();
        List<Product> products = Arrays.asList(product1, product2);

        //when
        when(productRepository.findAll()).thenReturn(products);
        List<Product> searchResult = productService.getProductsByCategory(categoryName);

        //then
        assertThat(searchResult, hasSize(1));
        assertThat(searchResult.get(0).getId(),is(1L));

    }

    @Test
    void deleteProduct() {
    }

    private List<Product> generateTestData() {
        Product bike = new Product(1L,"Bike",150,"New bike",null,new Category(),new User());
        Product jacket = new Product(2L,"Jacket",50,"New jacket",null,new Category(),new User());

        return Arrays.asList(bike, jacket);
    }
}