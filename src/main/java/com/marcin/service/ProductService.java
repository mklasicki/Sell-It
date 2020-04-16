package com.marcin.service;


import com.marcin.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    void saveProduct(Product theProduct);

    Product getProduct(int id);
}
