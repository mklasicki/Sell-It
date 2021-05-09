package com.marcin.service.impl;

import com.marcin.exceptions.EmptySearchFormFieldException;
import com.marcin.repositories.ProductRepository;
import com.marcin.domain.Product;
import com.marcin.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @Override
    public List<Product> getAll() {
        log.info("[ProductServiceImpl]: Getting list of all the products");
        return productRepository.findAll();
    }

    @Override
    public List<Product> findProductByName(String productName) {
        if (productName == null || productName.trim().isEmpty()) {
            throw new EmptySearchFormFieldException("Search field cannot be empty");
        }

        List<Product> resultProducts;

        resultProducts = productRepository.findAll().stream()
                        .filter(p -> StringUtils.containsIgnoreCase(p.getProductName(),productName))
                        .collect(Collectors.toList());

        log.info("[ProductServiceImpl]: All products: {}, found products: {}", productRepository.findAll().size(), resultProducts.size());

        return resultProducts;
    }

    @Override
    public void registerNewProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getProductsByUserId(Long userId) {
        log.info("[ProductServiceImpl]: Getting all products for user with id {}", userId);
        return productRepository.findAll().stream()
                    .filter(p -> p.getUser().getId().equals(userId)).collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        log.info("[ProductServiceImpl]: Getting all products from category {}", category);
        return productRepository.findAll().stream()
                    .filter(p -> p.getCategory().getName().equals(category)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
        log.info("[ProductServiceImpl]: Deleted product with id {}", id);
    }

}
