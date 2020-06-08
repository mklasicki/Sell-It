package com.marcin.service;


import com.marcin.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    void saveProduct(Product theProduct);

    Product getProduct(Long id);

    List<Product> findProductByName(String productName);

    void deleteProduct(Long id);

    void registerNewProduct(Product product);

    List<Product> getProductByUserId(Long userId);

 }
