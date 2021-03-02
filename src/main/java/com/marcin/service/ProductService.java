package com.marcin.service;


import com.marcin.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    List<Product> findProductByName(String productName);

    void registerNewProduct(Product product);

    List<Product> getProductsByUserId(Long userId);

    List<Product> getProductsByCategory(String category);

    void deleteProduct(Long id);

 }
