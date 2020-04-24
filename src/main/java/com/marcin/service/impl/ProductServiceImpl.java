package com.marcin.service.impl;


import com.marcin.daos.ProductDAO;
import com.marcin.domain.Category;
import com.marcin.domain.Product;
import com.marcin.domain.User;
import com.marcin.dto.RegisterProductDTO;
import com.marcin.service.CategoryService;
import com.marcin.service.ProductService;
import com.marcin.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;
    private final CategoryService categoryService;
    private final UserService userService;

    public ProductServiceImpl(ProductDAO productDAO, CategoryService categoryService, UserService userService) {
        this.productDAO = productDAO;
        this.categoryService = categoryService;
        this.userService = userService;
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
    public List<Product> findProductByName(String productName) {
        List<Product> products = productDAO.getProductByName(productName);
        return products;
    }

    //    @Override
//    @Transactional
//    public boolean deleteProduct(String productName) {
//        return productDAO.deleteProduct(productName);
//    }

    @Override
    public void registerNewProduct(RegisterProductDTO registerProductDTO) {

        Category category = categoryService.getCategoryById(Long.parseLong(registerProductDTO.getCategory()));
        Product product = createProductFrom(registerProductDTO, category);
        productDAO.saveProduct(product);
    }

    private Product createProductFrom(RegisterProductDTO registerProductDTO, Category category) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("Przypisano produkt do usera " + username + " o id " + userService.findUserByName(username).getId());
        Product product = new Product();
        product.setUser(userService.findUserByName(username));
        product.setCategory(category);
        product.setProductDescription(registerProductDTO.getDescription());
        product.setProductName(registerProductDTO.getName());
        product.setProductPrice(registerProductDTO.getPrice());
        product.setImage(registerProductDTO.getImage());
        return product;
    }
}
