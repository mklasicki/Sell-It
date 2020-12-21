package com.marcin.converters.impl;

import com.marcin.converters.Converter;
import com.marcin.domain.Category;
import com.marcin.domain.Product;
import com.marcin.domain.User;
import com.marcin.dto.ProductDTO;
import com.marcin.service.CategoryService;
import com.marcin.service.StorageService;
import com.marcin.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;


import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProductConverterImpl implements Converter<ProductDTO, Product> {

    private final UserService userService;
    private final CategoryService categoryService;
    private final StorageService storageService;
    private final Logger log = LoggerFactory.getLogger(ProductConverterImpl.class);


    @Override
    public Product to(ProductDTO productDTO) {

        return new Product(
                productDTO.getId(),
                productDTO.getName(),
                productDTO.getProductPrice(),
                productDTO.getProductDescription(),
                setImage(productDTO),
                setCategory(productDTO),
                setUser(productDTO));
    }

    @Override
    public ProductDTO from(Product product) {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getProductName());
        productDTO.setProductPrice(product.getProductPrice());
        productDTO.setCategory(product.getCategory().getName());
        productDTO.setProductDescription(product.getProductDescription());
        productDTO.setImageName(product.getImage());

        log.info("Conversion from product do productDTO");

        return productDTO;
    }

    public List<ProductDTO> listConverter(List<Product> products) {

        log.info("Conversion of list with products to list with productsDTO");

        return products.stream().map(this::from).collect(Collectors.toList());
    }

    private String setImage(ProductDTO productDTO) {
        return storageService.store(productDTO.getImage());
    }

    private Category setCategory(ProductDTO productDTO) {
        return categoryService.getCategoryById(Long.parseLong(productDTO.getCategory()));
    }

    private User setUser(ProductDTO productDTO) {
        return userService.findByName(productDTO.getPrincipal().getName());
    }


}


