package com.marcin.converters.impl;

import com.marcin.converters.Converter;
import com.marcin.domain.Product;
import com.marcin.dto.ProductDTO;
import com.marcin.service.CategoryService;
import com.marcin.service.StorageService;
import com.marcin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ProductConverterImpl implements Converter<ProductDTO, Product> {

    private final UserService userService;
    private final CategoryService categoryService;
    private final StorageService storageService;
    private final Logger log = LoggerFactory.getLogger(ProductConverterImpl.class);

    public ProductConverterImpl(UserService userService, CategoryService categoryService, StorageService storageService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.storageService = storageService;
    }

    @Override
    public Product to(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setProductName(productDTO.getName());
        product.setProductDescription(productDTO.getDescription());
        product.setUser(userService.findUserByName(productDTO.getPrincipal().getName()));
        product.setProductPrice(productDTO.getPrice());
        product.setImage(storageService.store(productDTO.getImage()));
        product.setCategory(categoryService.getCategoryById(Long.parseLong(productDTO.getCategory())));

        log.info("Konwersja z productDTO {} na product {}", productDTO, product);

        return product;
    }

    @Override
    public ProductDTO from(Product product) {
        return null;
    }
}
