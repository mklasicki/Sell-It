package com.marcin.controllers;


import com.marcin.domain.Category;
import com.marcin.domain.Product;
import com.marcin.dto.RegisterProductDTO;
import com.marcin.facades.CategoryFacade;
import com.marcin.facades.ProductFacade;
import com.marcin.service.ProductService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.persistence.NoResultException;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.apache.tomcat.util.http.fileupload.FileUtils.*;

@Controller
public class ProductController {

    private final ProductFacade productFacade;
    private final ProductService productService;
    private final CategoryFacade categoryFacade;

    public ProductController(ProductFacade productFacade, ProductService productService, CategoryFacade categoryFacade) {
        this.productFacade = productFacade;
        this.productService = productService;
        this.categoryFacade = categoryFacade;
    }

    @GetMapping("/main")
    public String getProducts(Model model) {
        List<Product> theProducts = productService.getProducts();
        model.addAttribute("products", theProducts);
        return "main";
    }

    @GetMapping("/addProduct")
    public String showProduct(Model model) {
        RegisterProductDTO registerProductDTO = new RegisterProductDTO();
        List<Category> categories = categoryFacade.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("product", registerProductDTO);
        return "product-form2";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") RegisterProductDTO registerProductDTO) {
        productFacade.registerNewProduct(registerProductDTO);
        return "redirect:/myPage";
    }

//    @GetMapping("/deleteProduct")
//    public String deleteProduct(@RequestParam("productName") String productName, Model model) {
//        productService.deleteProduct(productName);
//        return "test";
//    }

    @GetMapping("/searchProduct")
    public String searchProductByName(@RequestParam("productName") String productName, Model model) throws NoResultException {
        List<Product> products = productService.findProductByName(productName);
        if (products.isEmpty()) {
           return "error";
       }
        try {
            model.addAttribute("products", products);
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
