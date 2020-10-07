package com.marcin.controllers;

import com.marcin.domain.Product;
import com.marcin.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class MainPageController {

    private final ProductService productService;

    public MainPageController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/main")
    public String getProducts (Model model) throws IOException {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "main";
    }
}
