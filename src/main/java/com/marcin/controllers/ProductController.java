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
    public String saveProduct(@Valid @ModelAttribute("product") ProductDTO productDTO, BindingResult result, Principal principal, Model model) {
        model.addAttribute("categories", categoryFacade.getAllCategories());
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
    public String search(@RequestParam("productName") String productName, Model model) {
        model.addAttribute("products", productConverter.listConverter(productService.findProductByName(productName)));
        model.addAttribute("listSize", productService.findProductByName(productName).size());
        return "search-result";
    }


}