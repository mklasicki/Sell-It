package com.marcin.service;


import com.marcin.domain.Product;
import com.marcin.dto.RegisterProductDTO;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    void saveProduct(Product theProduct);

    Product getProduct(Long id);

    List<Product> findProductByName(String productName);

    void deleteProduct(Long id);

    void registerNewProduct(RegisterProductDTO registerProductDTO);

    List<Product> getProductByUserId(Long userId);



 }
