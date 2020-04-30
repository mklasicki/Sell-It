package com.marcin.daos;


import com.marcin.domain.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> getProducts();

    void saveProduct(Product theProduct);

    Product getProduct(Long id);

<<<<<<< HEAD
    List<Product> getProductByName(String productName);

    void deleteProduct(Long id);

    List<Product> getProductByUserId(Long userId);
=======
    Product getProductByName(String productName);

    boolean deleteProduct(String productName);

>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed

}
