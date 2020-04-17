package com.marcin.service.impl;


import com.marcin.daos.ProductDAO;
import com.marcin.domain.Product;
import com.marcin.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    @Transactional
    public List<Product> getProducts() {
        return productDAO.getProducts();
    }

    @Override
    @Transactional
    public void saveProduct(Product theProduct) {
        productDAO.saveProduct(theProduct);

    }

    @Override
    @Transactional
    public Product getProduct(Long id) {
        return productDAO.getProduct(id);
    }

    @Override
    @Transactional
    public Product findProductByName(String productName) {
        return productDAO.getProductByName(productName);
    }

    @Override
    @Transactional
    public boolean deleteProduct(String productName) {
        return productDAO.deleteProduct(productName);
    }
}
