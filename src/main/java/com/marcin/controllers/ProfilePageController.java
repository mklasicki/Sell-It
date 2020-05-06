package com.marcin.controllers;

import com.marcin.domain.Product;
import com.marcin.facades.SearchFacade;
import com.marcin.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



import java.security.Principal;
import java.util.List;

@Controller
public class ProfilePageController {

    private final ProductService productService;
    private final SearchFacade searchFacade;


    public ProfilePageController(ProductService productService, SearchFacade searchFacade) {
        this.productService = productService;
        this.searchFacade = searchFacade;
    }

    @GetMapping("/myPage")
    public String myPage(Model model) {
         List <Product> products = productService.getProducts();
         model.addAttribute("products", products);
        return "my-page";
    }

    @GetMapping("/showMyProducts")
    public String showUserProducts(Model model, Principal principal) {
        List<Product> userProducts = searchFacade.showMyProducts(principal.getName());
        model.addAttribute("userProducts",userProducts);
        return "my-products-page";
    }


}
