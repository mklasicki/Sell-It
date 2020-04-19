package com.marcin.facades.impl;

import com.marcin.dto.RegisterProductDTO;
import com.marcin.facades.ProductFacade;
import com.marcin.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductFacadeImpl implements ProductFacade {

    private final ProductService productService;

    public ProductFacadeImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void registerNewProduct(RegisterProductDTO registerProductDTO) {
        productService.registerNewProduct(registerProductDTO);
    }
}
