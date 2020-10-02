package com.marcin.controllers;

import com.marcin.domain.Product;
import com.marcin.domain.User;
import com.marcin.service.ProductService;
import com.marcin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
         List <Product> products = productService.getProducts();
         getLoggedUser(principal);
         model.addAttribute("products", products);
        return "my-page";
    }

    @GetMapping("/myProducts")
    public String myProducts(Model model, Principal principal) {
        getLoggedUser(principal);
        List<Product> products = productService.getProducts()
                .stream().filter(product -> product.getUser().getId().equals(getLoggedUser(principal).getId())).collect(Collectors.toList());
        model.addAttribute("products", products);
        return "my-products-page";
    }

    private User getLoggedUser(Principal principal) {
        return userService.findByName(principal.getName());
    }

}
