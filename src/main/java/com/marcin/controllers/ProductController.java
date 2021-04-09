package com.marcin.controllers;


import com.marcin.dto.ProductDTO;
import com.marcin.facades.CategoryFacade;
import com.marcin.facades.ProductFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;


@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductFacade productFacade;
    private final CategoryFacade categoryFacade;
    private final Logger logger = LoggerFactory.getLogger(ProductController.class);


    public ProductController(ProductFacade productFacade, CategoryFacade categoryFacade) {
        this.productFacade = productFacade;
        this.categoryFacade = categoryFacade;
    }

    @GetMapping("/add-form")
    public String showProduct(Model model) {
        model.addAttribute("categories", categoryFacade.getAllCategories());
        model.addAttribute("product", new ProductDTO());
        return "add-item";
    }

    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute("product") ProductDTO productDTO, BindingResult result, Principal principal, Model model) {
        model.addAttribute("categories", categoryFacade.getAllCategories());
        return productFacade.validateAndRegisterNewProduct(productDTO, result, principal);
    }


    @GetMapping("/delete")
    public String showFormForDelete(@RequestParam("productId") Long id, Model model) throws IOException {
        productFacade.deleteById(id);
        model.addAttribute("products", productFacade.getAll());
        return "redirect:/my-products";
    }

    @GetMapping("/{category}")
    public String showProductsByCategory(@PathVariable String category, Model model) throws IOException {
        model.addAttribute("products", productFacade.getProductsByCategory(category));
        logger.info("Searching for item in category {}", category);
        return "category";
    }

    @GetMapping("/search")
    public String search(@RequestParam("productName") String productName, Model model) throws IOException {
        model.addAttribute("products", productFacade.searchProductsByName(productName));
        model.addAttribute("listSize", productFacade.searchProductsByName(productName).size());
        return "search";
    }

}