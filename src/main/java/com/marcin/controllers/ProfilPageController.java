package com.marcin.controllers;

import com.marcin.domain.Product;
import com.marcin.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
 class ProfilPageController {

    private final ProductService productService;

    public ProfilPageController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("myPage")
    public String myPage(Model model) {
        List<Product> theProducts = productService.getProducts();
        model.addAttribute("products", theProducts);
        return "my-page";
    }

}
