package com.marcin.facades.impl;

import com.marcin.converters.Converter;
import com.marcin.domain.Product;
import com.marcin.dto.ProductDTO;
import com.marcin.facades.ProductFacade;
import com.marcin.service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;


import java.io.IOException;
import java.security.Principal;
import java.util.List;


@Service
public class ProductFacadeImpl implements ProductFacade {

    private final ProductService productService;
    private final Converter<ProductDTO, Product> converter;

    private final Logger logger = LoggerFactory.getLogger(ProductFacade.class);

    public ProductFacadeImpl(ProductService productService, @Qualifier("productConverterImpl") Converter<ProductDTO, Product> converter) {
        this.productService = productService;
        this.converter = converter;
    }

    @Override
    public List<ProductDTO> getAll() throws IOException {
        return converter.listConverter(productService.getAll());
    }

    public String validateAndRegisterNewProduct(ProductDTO productDTO, BindingResult result, Principal principal) {

        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors) {
                logger.info("Error in product form {}", error);
            }
            return "product-form";
        }

        productDTO.setPrincipal(principal);
        productService.registerNewProduct(converter.to(productDTO));

        logger.info("Created new product");

        return "redirect:/my-page";
    }

    @Override
    public void deleteById(Long id) {
        productService.deleteProduct(id);
    }
}
