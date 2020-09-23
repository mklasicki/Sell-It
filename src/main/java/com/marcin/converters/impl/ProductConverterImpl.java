package com.marcin.converters.impl;

import com.marcin.converters.Converter;
import com.marcin.domain.Product;
import com.marcin.dto.ProductDTO;
import com.marcin.service.CategoryService;
import com.marcin.service.StorageService;
import com.marcin.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

        Product product = new Product();
        product.setId(productDTO.getId());
        product.setProductName(productDTO.getName());
        product.setProductDescription(productDTO.getDescription());
        product.setUser(userService.findByName(productDTO.getPrincipal().getName()));
        product.setProductPrice(productDTO.getPrice());
        product.setImage(storageService.store(productDTO.getImage()));
        product.setCategory(categoryService.getCategoryById(Long.parseLong(productDTO.getCategory())));

        log.info("Conversion from productDTO {} to product {}");

        return product;
    }

    @Override
    public ProductDTO from(Product product) throws IOException {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getProductName());
        productDTO.setPrice(product.getProductPrice());
        productDTO.setCategory(product.getCategory().getName());
        productDTO.setDescription(product.getProductDescription());
        productDTO.setImage((MultipartFile) storageService.loadAsResource(product.getImage()).getFile());

        log.info("Conversion from product do productDTO");

        return productDTO;
    }

    public List<ProductDTO> listConverter(List<Product> products) throws IOException {
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            productDTOS.add(from(products.get(i)));
        }

        log.info("Conversion of list with products to list with productsDTO");

        return productDTOS;
    }

}
