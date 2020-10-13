package com.marcin.controllers;

import com.marcin.facades.ProductFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;


@Controller
public class MainPageController {

    private final ProductFacade productFacade;

    public MainPageController(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    @GetMapping("/main")
    public String getProducts(Model model) throws IOException {
        model.addAttribute("products", productFacade.getAll());
        return "main";
    }
}
