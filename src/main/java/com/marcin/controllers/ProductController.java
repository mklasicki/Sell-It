package com.marcin.controllers;


import com.marcin.domain.Category;
import com.marcin.domain.Product;
import com.marcin.domain.User;
import com.marcin.dto.RegisterProductDTO;
import com.marcin.facades.CategoryFacade;
import com.marcin.facades.ProductFacade;
import com.marcin.service.ProductService;
import com.marcin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.persistence.NoResultException;
import java.security.Principal;
import java.util.List;


@Controller
public class ProductController {

    private final ProductFacade productFacade;
    private final ProductService productService;
    private final CategoryFacade categoryFacade;
    private final UserService userService;

    public ProductController(ProductFacade productFacade, ProductService productService,
                             CategoryFacade categoryFacade,UserService userService) {
        this.productFacade = productFacade;
        this.productService = productService;
        this.categoryFacade = categoryFacade;
        this.userService = userService;
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
    public String saveProduct(@ModelAttribute("product") RegisterProductDTO registerProductDTO,
                              Principal principal) {
        registerProductDTO.setPrincipal(principal);
        productFacade.registerNewProduct(registerProductDTO);
        return "redirect:/myPage";
    }

    @GetMapping("/showMyProducts")
    public String getUserProducts(Model model, Principal principal){
        User user = userService.findUserByName(principal.getName());
        List<Product> userProducts = productFacade.userProducts(user.getId(), productService.getProducts());
        model.addAttribute("userProducts", userProducts);
        return "my-products-page";
    }

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
