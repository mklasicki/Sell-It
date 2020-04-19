package com.marcin.service;


import com.marcin.domain.Product;
import com.marcin.dto.RegisterProductDTO;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    void saveProduct(Product theProduct);

    Product getProduct(Long id);

    Product findProductByName(String productName);

    boolean deleteProduct(String productName);

    void registerNewProduct(RegisterProductDTO registerProductDTO);
}
