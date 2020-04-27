package com.marcin.facades;


import com.marcin.domain.Product;
import com.marcin.dto.RegisterProductDTO;

import java.util.List;


public interface ProductFacade {

    void registerNewProduct(RegisterProductDTO registerProductDTO);

    List<Product> userProducts(Long userId, List<Product> productList);

}
