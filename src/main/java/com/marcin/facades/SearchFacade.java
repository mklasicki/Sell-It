package com.marcin.facades;

import com.marcin.domain.Product;


import java.util.List;

public interface SearchFacade {

    List<Product> showMyProducts(String userName);

    List<Product> searchProductsByName(String productName);

}
