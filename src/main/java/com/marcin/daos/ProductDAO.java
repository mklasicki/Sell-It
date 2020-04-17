package com.marcin.daos;


import com.marcin.domain.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> getProducts();

    void saveProduct(Product theProduct);

    Product getProduct(Long id);

    Product getProductByName(String productName);

    boolean deleteProduct(String productName);


}
