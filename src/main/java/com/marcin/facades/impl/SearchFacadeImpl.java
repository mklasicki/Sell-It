package com.marcin.facades.impl;

import com.marcin.domain.Product;
import com.marcin.domain.User;
import com.marcin.facades.SearchFacade;
import com.marcin.service.ProductService;


import com.marcin.service.UserService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SearchFacadeImpl implements SearchFacade {

    private final ProductService productService;
    private final UserService userService;

    public SearchFacadeImpl(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @Override
    public List<Product> showMyProducts(String username) {
        User user = userService.findByName(username);
        Long userId = user.getId();
        List<Product> userProducts = productService.getProductByUserId(userId);
        ;

        return userProducts;
    }

    @Override
    public List<Product> searchProductsByName(String productName) {


        return null;
    }
}
