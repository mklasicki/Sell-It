package com.marcin.controllers;

import com.marcin.facades.ProductFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;


@Controller
public class MainPageController {

    private final ProductFacade productFacade;
    private final Logger logger = LoggerFactory.getLogger(MainPageController.class);

    public MainPageController(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    @GetMapping({"", "/", "/main"})
    public String getProducts(Model model) throws IOException {
        model.addAttribute("products", productFacade.getAll());

        logger.info("[MainPageController]: Getting main page");

        return "index";
    }
}
