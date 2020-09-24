package com.marcin.controllers;

import com.marcin.domain.Product;
import com.marcin.domain.User;
import com.marcin.domain.UserSession;
import com.marcin.facades.SearchFacade;
import com.marcin.service.ProductService;
import com.marcin.service.UserService;
import com.marcin.service.UserSessionService;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.TimeZone;
import java.util.Timer;

@Controller
public class ProfilePageController {

    private final ProductService productService;
    private final SearchFacade searchFacade;
    private final UserSessionService userSessionService;
    private final UserService userService;


    public ProfilePageController(ProductService productService, SearchFacade searchFacade, UserSessionService userSessionService
                                , UserService userService) {
        this.productService = productService;
        this.searchFacade = searchFacade;
        this.userSessionService = userSessionService;
        this.userService = userService;
    }

    @GetMapping("/myPage")
    public String myPage(Model model, Principal principal) {
         List <Product> products = productService.getProducts();
         User user = userService.findByName(principal.getName());
         UserSession userSession = new UserSession(user.getId(),LocalDate.now());
         userSessionService.save(userSession);
         model.addAttribute("products", products);
        return "my-page";
    }

    @GetMapping("/myProducts")
    public String myProducts() {

        return "my-products-page";
    }

}
