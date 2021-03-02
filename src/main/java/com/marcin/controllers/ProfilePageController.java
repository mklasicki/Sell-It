package com.marcin.controllers;


import com.marcin.domain.User;
import com.marcin.facades.ProductFacade;
import com.marcin.facades.UserFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.io.IOException;
import java.security.Principal;


@Controller
public class ProfilePageController {

    private final ProductFacade productFacade;
    private final UserFacade userFacade;


    public ProfilePageController(ProductFacade productFacade, UserFacade userFacade) {
        this.productFacade = productFacade;
        this.userFacade = userFacade;
    }

    @GetMapping("/my-page")
    public String myPage(Model model, Principal principal) throws IOException {
        model.addAttribute("user", getLoggedUser(principal));
        model.addAttribute("products", productFacade.getAll());
        return "my-page";
    }

    @GetMapping("/my-products")
    public String myProducts(Model model, Principal principal) throws IOException {
        model.addAttribute("user", getLoggedUser(principal));
        model.addAttribute("products", productFacade.getProductsByUserId(getLoggedUser(principal).getId()));
        return "my-products-page";
    }

    private User getLoggedUser(Principal principal) {
        return userFacade.findUserByName(principal.getName());
    }

}

