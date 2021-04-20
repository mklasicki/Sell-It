package com.marcin.controllers;


import com.marcin.domain.User;
import com.marcin.dto.UserDetailsDTO;
import com.marcin.facades.ProductFacade;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.io.IOException;


@Controller
public class ProfilePageController {

    private final ProductFacade productFacade;

    public ProfilePageController(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    @GetMapping("/my-page")
    @ResponseStatus(HttpStatus.OK)
    public String myPage(Model model) throws IOException {
        model.addAttribute("user", getLoggedUser());
        model.addAttribute("products", productFacade.getAll());
        return "user-page";
    }

    @GetMapping("/my-products")
    @ResponseStatus(HttpStatus.OK)
    public String myProducts(Model model) throws IOException {
        model.addAttribute("user", getLoggedUser());
        model.addAttribute("products", productFacade.getProductsByUserId(getLoggedUser().getId()));
        return "user-items";
    }

    private User getLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsDTO user = (UserDetailsDTO) authentication.getPrincipal();
        return user.getUser();
    }

}

