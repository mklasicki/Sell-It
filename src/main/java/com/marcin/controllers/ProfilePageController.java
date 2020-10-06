package com.marcin.controllers;


import com.marcin.domain.User;
import com.marcin.service.ProductService;
import com.marcin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.security.Principal;


@Controller
public class ProfilePageController {

    private final ProductService productService;
    private final UserService userService;


    public ProfilePageController(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping("/myPage")
    public String myPage(Model model, Principal principal) {
        model.addAttribute("user", getLoggedUser(principal));
        model.addAttribute("products", productService.getProducts());
        return "my-page";
    }

    @GetMapping("/myProducts")
    public String myProducts(Model model, Principal principal) {
        model.addAttribute("products", productService.getProductByUserId(getLoggedUser(principal).getId()));
        return "my-products-page";
    }

    private User getLoggedUser(Principal principal) {
        return userService.findByName(principal.getName());
    }

}

