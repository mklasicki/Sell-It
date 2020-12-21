package com.marcin.service.impl;

import com.marcin.daos.ProductDAO;
import com.marcin.domain.Product;
import com.marcin.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        List<Product> products = productDAO.getProducts().stream()
                .filter(p->p.getProductName().equals(productName)).collect(Collectors.toList());
        log.info("Getting product with name {}" , productName);
        return products ;
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
        log.info("Deleted product with id {}", id);
        productDAO.deleteProduct(id);
    }


}
