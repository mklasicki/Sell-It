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

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ProductConverterImpl implements Converter<ProductDTO, Product> {

    private final UserService userService;
    private final CategoryService categoryService;
    private final StorageService storageService;
    private final Logger log = LoggerFactory.getLogger(ProductConverterImpl.class);


    @Override
    public Product to(ProductDTO productDTO) {

        log.info("Conversion from productDTO to product");

        return new Product(
                productDTO.getId(),
                productDTO.getName(),
                productDTO.getPrice(),
                productDTO.getDescription(),
                setImage(productDTO),
                setCategory(productDTO),
                setUser(productDTO));
    }

    @Override
    public ProductDTO from(Product product) {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getProductName());
        productDTO.setPrice(product.getProductPrice());
        productDTO.setCategory(product.getCategory().getName());
        productDTO.setDescription(product.getProductDescription());


        log.info("Conversion from product do productDTO");

        return productDTO;
    }

    public List<ProductDTO> listConverter(List<Product> products) {
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            productDTOS.add(from(products.get(i)));
        }

        log.info("Conversion of list with products to list with productsDTO");

        return productDTOS;
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
