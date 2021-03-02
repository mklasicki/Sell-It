package com.marcin.service.impl;

import com.marcin.daos.ProductDAO;
import com.marcin.domain.Product;
import com.marcin.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;

    }

    @Override
    @Transactional
    public List<Product> getProducts() {
        log.info("Getting list of all the products");
        return productDAO.getProducts();
    }

    @Override
    public List<Product> findProductByName(String productName) {
        if (productName == null || productName.trim().isEmpty()) {
            throw new NullPointerException("Search field cannot be empty");
        }

        List<Product> allProducts = productDAO.getProducts();
        List<Product> resultProducts = new ArrayList<>();

        for (Product allProduct : allProducts) {
            if (StringUtils.containsIgnoreCase(allProduct.getProductName(), productName)) {
                resultProducts.add(allProduct);
            }
        }

        log.info("All products: {}, found products: {}", allProducts.size(), resultProducts.size());

        return resultProducts;
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
    public List<Product> getProductsByCategory(String category) {
        return productDAO.getProducts()
            .stream().filter(p -> p.getCategory().getName().equals(category)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        productDAO.deleteProduct(id);
        log.info("Deleted product with id {}", id);
    }

}
