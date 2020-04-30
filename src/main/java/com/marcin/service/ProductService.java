package com.marcin.service;


import com.marcin.domain.Product;
import com.marcin.dto.RegisterProductDTO;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    void saveProduct(Product theProduct);

    Product getProduct(Long id);

<<<<<<< HEAD
    List<Product> findProductByName(String productName);

    void deleteProduct(Long id);

    void registerNewProduct(RegisterProductDTO registerProductDTO);

    List<Product> getProductByUserId(Long userId);



 }
=======
    Product findProductByName(String productName);

    boolean deleteProduct(String productName);

    void registerNewProduct(RegisterProductDTO registerProductDTO);
}
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed
