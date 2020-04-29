package com.marcin.facades.impl;

import com.marcin.domain.Product;
import com.marcin.domain.User;
import com.marcin.dto.RegisterProductDTO;
import com.marcin.facades.ProductFacade;
import com.marcin.service.ProductService;
import com.marcin.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductFacadeImpl implements ProductFacade {

    private final ProductService productService;
    private final UserService userService;

    public ProductFacadeImpl(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @Override
    public void registerNewProduct(RegisterProductDTO registerProductDTO) {
        productService.registerNewProduct(registerProductDTO);
    }

    @Override
    public List<Product> userProducts(Long userId, List<Product> productList) {
        productList = productService.getProducts();
        User user = userService.findUserById(userId);
        List<Product> userProducts = new ArrayList<>();
         for(int i = 0; i < productList.size(); i++) {
             if(productList.get(i).getUser().getId() == userId) {
                 userProducts.add(productList.get(i));
             }
         }
        return userProducts ;
    }
}
