package com.marcin.controllers;

import com.marcin.domain.Product;
import com.marcin.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class ProfilePageController {

    private final ProductService productService;

    public ProfilePageController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/myPage")
    public String myPage(Model model) {
         List <Product> products = productService.getProducts();
         model.addAttribute("products", products);
        return "my-page";
    }

}
