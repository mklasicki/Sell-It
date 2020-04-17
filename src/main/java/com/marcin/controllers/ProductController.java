package com.marcin.controllers;


import com.marcin.domain.Category;
import com.marcin.domain.Product;
import com.marcin.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
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

    @RequestMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product theProduct) {
        productService.saveProduct(theProduct);
        return "redirect:/myPage";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("productName") String productName, Model model) {
        productService.deleteProduct(productName);
        return "test";
    }

    @GetMapping("/searchProduct")
    public String searchProductByName(@RequestParam("productName") String productName, Model model) throws NoResultException {
        Product theProduct = productService.findProductByName(productName);
        try {
            model.addAttribute("product", theProduct);
            System.out.println("Produkt o nazwie " + theProduct.getProductName() + " znaleziono");
            return "test";
        } catch (NoResultException e) {
            System.out.println("Nie znaleziono takiego produktu");
            return "error";
        }
    }

    @GetMapping("/getProduct")
    public String getProduct(@RequestParam("id") Long id, Model model) {
        Product theProduct = productService.getProduct(id);
        try {
            model.addAttribute("product", theProduct);
            System.out.println("Produkt " + theProduct.getProductName() + " znajduje sie na liście");
            return "test";
        } catch (NullPointerException e) {
            System.out.println("Nie ma takiego przedmiotu w bazie!");
            return "error";
        }
    }
}
