package com.marcin.controllers;


import com.marcin.domain.Product;
import com.marcin.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/main")
    public String getProducts(Model model) {
        List<Product> theProducts = productService.getProducts();
        model.addAttribute("products", theProducts);
        return "main";
    }

    @GetMapping("/addProduct")
    public String showProduct(Model model) {
        Product theProduct = new Product();
        model.addAttribute("product", theProduct);
        return "product-form2";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@Valid @ModelAttribute("product") Product theProduct) {
        productService.saveProduct(theProduct);
        return "redirect:/main";
    }

}
