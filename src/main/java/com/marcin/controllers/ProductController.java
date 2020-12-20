package com.marcin.controllers;


import com.marcin.converters.impl.ProductConverterImpl;
import com.marcin.domain.Product;
import com.marcin.dto.ProductDTO;
import com.marcin.facades.CategoryFacade;
import com.marcin.facades.ProductFacade;
import com.marcin.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;


import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductFacade productFacade;
    private final ProductService productService;
    private final CategoryFacade categoryFacade;
    private final ProductConverterImpl productConverter;
    private final Logger logger = LoggerFactory.getLogger(ProductController.class);


    public ProductController(ProductFacade productFacade, ProductService productService, CategoryFacade categoryFacade, ProductConverterImpl productConverter) {
        this.productFacade = productFacade;
        this.productService = productService;
        this.categoryFacade = categoryFacade;
        this.productConverter = productConverter;
    }

    @GetMapping("/add-form")
    public String showProduct(Model model) {
        model.addAttribute("categories", categoryFacade.getAllCategories());
        model.addAttribute("product", new ProductDTO());
        return "product-form";
    }

    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute("product") ProductDTO productDTO, BindingResult result, Principal principal) {
        return productFacade.validateAndRegisterNewProduct(productDTO, result, principal);
    }


    @GetMapping("/delete")
    public String showFormForDelete(@RequestParam("productId") Long id, Model model) throws IOException {
        productFacade.deleteById(id);
        model.addAttribute("products", productFacade.getAll());
        return "redirect:/my-products";
    }

    @GetMapping("/{category}")
    public String showProductsByCategory(@PathVariable String category, Model model) {
        model.addAttribute("products", productConverter.listConverter(productService.getProductsByCategory(category)));
        logger.info("Searching for item in category {}", category);
        return "category-product";
    }

    @GetMapping("/search")
    public String searchProductByName(@RequestParam("productName") String productName, Model model) throws NoResultException {
        List<Product> products = productService.findProductByName(productName);
        if (products.isEmpty()) {
            return "error";
        }
        try {
            model.addAttribute("products", products);
            return "test";
        } catch (NoResultException e) {
            System.out.println("Product with name {} not found" + productName);
            return "error";
        }
    }

    @GetMapping("/getProduct")
    public String getProduct(@RequestParam("id") Long id, Model model) {
        Product theProduct = productService.getProduct(id);
        try {
            model.addAttribute("product", theProduct);
            logger.info("Found product with id {}", id);
            return "test";
        } catch (NullPointerException e) {
            logger.info("Product with id {} not found", id);
            return "error";
        }
    }

}