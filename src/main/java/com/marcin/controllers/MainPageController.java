package com.marcin.controllers;

import com.marcin.facades.ProductFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;


@Controller
public class MainPageController {

    private final ProductFacade productFacade;
    private final Logger logger = LoggerFactory.getLogger(MainPageController.class);

    public MainPageController(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    @GetMapping({"", "/", "/main"})
    @ResponseStatus(HttpStatus.OK)
    public String getProducts(Model model) throws IOException {
        model.addAttribute("products", productFacade.getAll());

        logger.info("[MainPageController]: Getting main page");

        return "index";
    }
}
