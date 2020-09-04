package com.marcin.facades.impl;

import com.marcin.converters.Converter;
import com.marcin.domain.Product;
import com.marcin.dto.ProductDTO;
import com.marcin.facades.ProductFacade;
import com.marcin.service.ProductService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.List;


@Service
public class ProductFacadeImpl implements ProductFacade {

    private final ProductService productService;
    private final Converter converter;

    public ProductFacadeImpl(ProductService productService, @Qualifier("productConverterImpl") Converter converter) {
        this.productService = productService;
        this.converter = converter;
    }


    @Override
    public void registerNewProduct(ProductDTO productDTO) {
        Product product = (Product) converter.to(productDTO);
        productService.registerNewProduct(product);
    }

    @Override
    public List<ProductDTO> getAll() throws IOException {
        return converter.listConverter(productService.getProducts());
    }
}
