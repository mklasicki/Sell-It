package com.marcin.controllers;


import com.marcin.domain.Category;
import com.marcin.domain.Product;
import com.marcin.dto.RegisterProductDTO;
import com.marcin.facades.CategoryFacade;
import com.marcin.facades.ProductFacade;
import com.marcin.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD
import javax.persistence.NoResultException;
import java.security.Principal;
=======

import javax.persistence.NoResultException;
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed
import java.util.List;


@Controller
public class ProductController {

    private final ProductFacade productFacade;
<<<<<<< HEAD
    private final ProductService productService;
    private final CategoryFacade categoryFacade;

    public ProductController(ProductFacade productFacade, ProductService productService,
                             CategoryFacade categoryFacade) {
=======

    private final ProductService productService;
    private final CategoryFacade categoryFacade;

    public ProductController(ProductFacade productFacade, ProductService productService, CategoryFacade categoryFacade) {
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed
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
<<<<<<< HEAD
    public String saveProduct(@ModelAttribute("product") RegisterProductDTO registerProductDTO,
                              Principal principal) {
        registerProductDTO.setPrincipal(principal);
=======
    public String saveProduct(@ModelAttribute("product") RegisterProductDTO registerProductDTO) {
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed
        productFacade.registerNewProduct(registerProductDTO);
        return "redirect:/myPage";
    }

<<<<<<< HEAD

    @GetMapping("/deleteProduct")
    public String showFormForDelete(@RequestParam("productId") Long id, Model model) {
        productService.deleteProduct(id);
        List<Product> theProducts = productService.getProducts();
        model.addAttribute("products", theProducts);
        return "my-page";
    }

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

=======
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

>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed
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
<<<<<<< HEAD


=======
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed
}
