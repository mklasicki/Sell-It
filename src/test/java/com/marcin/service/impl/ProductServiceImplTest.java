package com.marcin.service.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.marcin.domain.Category;
import com.marcin.domain.Product;
import com.marcin.domain.User;
import com.marcin.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
    void getAll() {

        //given
        Product bike = new Product(1L,"Bike",150,"New bike",null,new Category(),new User());
        Product jacket = new Product(2L,"Jacket",50,"New jacket",null,new Category(),new User());
        List<Product> products = Arrays.asList(bike, jacket);
        when(productRepository.findAll()).thenReturn(products);

        //when
        List<Product> allProducts = productService.getAll();

        //than
        assertThat(allProducts, hasSize(2));
        assertThat(allProducts, is(not(empty())));
        verify(productRepository, times(1)).findAll();

    }

    @Test
    void findProductByName() {
    }

    @Test
    void registerNewProduct() {
    }

    @Test
    void getProductsByUserId() {
    }

    @Test
    void getProductsByCategory() {
    }

    @Test
    void deleteProduct() {
    }
}