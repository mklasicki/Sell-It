package com.marcin.service.impl;

import com.marcin.daos.ProductDAO;
import com.marcin.domain.Category;
import com.marcin.domain.Product;
import com.marcin.domain.User;
import com.marcin.dto.RegisterProductDTO;
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
    public List<Product> findProductByName(String productName)
    {
        return productDAO.getProductByName(productName);
    }

    @Override
    @Transactional
    public void registerNewProduct(RegisterProductDTO registerProductDTO) {
        Product product = createProductFrom(registerProductDTO);
        productDAO.saveProduct(product);
    }

    @Override
    public List<Product> getProductByUserId(Long userId) {
        return productDAO.getProductByUserId(userId);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        productDAO.deleteProduct(id);
    }

    private Product createProductFrom(RegisterProductDTO registerProductDTO) {
        Category category = categoryService.getCategoryById(Long.parseLong(registerProductDTO.getCategory()));
        User user = userService.findUserByName(registerProductDTO.getPrincipal().getName());
        String imageUrl = storageService.store(registerProductDTO.getImage());
        Product product = new Product();
        product.setUser(user);
        product.setCategory(category);
        product.setProductDescription(registerProductDTO.getDescription());
        product.setProductName(registerProductDTO.getName());
        product.setProductPrice(registerProductDTO.getPrice());
        product.setImage(imageUrl);

        log.info("Przypisuję product {} do użytkownika {}", product, user);

        return product;
    }

}
