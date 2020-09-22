package com.marcin.service.impl;

import com.marcin.daos.ProductDAO;
import com.marcin.domain.Product;
import com.marcin.service.CategoryService;
import com.marcin.service.ProductService;
import com.marcin.service.StorageService;
import com.marcin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductDAO productDAO;
    private final CategoryService categoryService;
    private final UserService userService;
    private final StorageService storageService;

    public ProductServiceImpl(ProductDAO productDAO, CategoryService categoryService, UserService userService, StorageService storageService) {
        this.productDAO = productDAO;
        this.categoryService = categoryService;
        this.userService = userService;
        this.storageService = storageService;
    }

    @Override
    @Transactional
    public List<Product> getProducts() {
        log.info("Getting list of all the products");
        return productDAO.getProducts();
    }

    @Override
    @Transactional
    public void saveProduct(Product theProduct) {
        log.info("Saving new product {}", theProduct);
        productDAO.saveProduct(theProduct);
    }

    @Override
    @Transactional
    public Product getProduct(Long id) {
        log.info("Getting product with id {}", id);
        return productDAO.getProduct(id);
    }

    @Override
    public List<Product> findProductByName(String productName) {
        log.info("Getting product with name {}" , productName);
        return productDAO.getProductByName(productName);
    }

    @Override
    @Transactional
    public void registerNewProduct(Product product) {
        productDAO.saveProduct(product);
    }

    @Override
    public List<Product> getProductByUserId(Long userId) {
        return productDAO.getProductByUserId(userId);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        log.info("Deleted product with id {}", id);
        productDAO.deleteProduct(id);
    }


}
