package com.marcin.service.impl;


import com.marcin.daos.ProductDAO;
import com.marcin.domain.Category;
import com.marcin.domain.Product;
import com.marcin.domain.User;
import com.marcin.dto.RegisterProductDTO;
import com.marcin.service.CategoryService;
import com.marcin.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductDAO productDAO, CategoryService categoryService) {
        this.productDAO = productDAO;
        this.categoryService = categoryService;
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

    @Override
    public void registerNewProduct(RegisterProductDTO registerProductDTO) {

        Category category = categoryService.getCategoryById(Long.parseLong(registerProductDTO.getCategory()));
        Product product = createProductFrom(registerProductDTO, category);
        productDAO.saveProduct(product);
    }

    private Product createProductFrom(RegisterProductDTO registerProductDTO, Category category) {
        Product product = new Product();
        product.setUser(new User()); // TODO: dodać też użytkownika z bazy bo teraz za każdym razem tworzy nowego użytkownika w bazie
        category.addProduct(product);
        product.setProductDescription(registerProductDTO.getDescription());
        product.setProductName(registerProductDTO.getName());
        product.setProductPrice(registerProductDTO.getPrice());
        product.setImage(registerProductDTO.getImageUrl());
        return product;
    }
}
