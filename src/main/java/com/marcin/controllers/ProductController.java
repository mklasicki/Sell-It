package com.marcin.controllers;


import com.marcin.domain.Category;
import com.marcin.domain.Product;
import com.marcin.dto.ProductDTO;
import com.marcin.facades.CategoryFacade;
import com.marcin.facades.ProductFacade;
import com.marcin.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import javax.persistence.NoResultException;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;


import java.util.List;


@Controller
public class ProductController {

    private final ProductFacade productFacade;
    private final ProductService productService;
    private final CategoryFacade categoryFacade;
    private final Logger logger = LoggerFactory.getLogger(ProductController.class);


    public ProductController(ProductFacade productFacade, ProductService productService, CategoryFacade categoryFacade) {
            this.productFacade = productFacade;
            this.productService = productService;
            this.categoryFacade = categoryFacade;
        }

        @GetMapping("/main")
        public String getProducts (Model model) throws IOException {
           List<Product> products = productService.getProducts();
            model.addAttribute("products", products);
            return "main";
        }

        @GetMapping("/addProduct")
        public String showProduct (Model model){
           ProductDTO productDTO = new ProductDTO();
            List<Category> categories = categoryFacade.getAllCategories();
            model.addAttribute("categories", categories);
            model.addAttribute("product", productDTO);
            return "product-form";
        }

        @PostMapping("/saveProduct")
        public String saveProduct (@Valid @ModelAttribute("product")ProductDTO productDTO, BindingResult result, Principal principal){

            if (result.hasErrors()) {
                List<ObjectError> errors = result.getAllErrors();
                for (ObjectError error: errors ) {
                    logger.info("Errors while filling form  {}", error);
                }

                return "product-form";
            }

            productDTO.setPrincipal(principal);
            productFacade.registerNewProduct(productDTO);

            logger.info("Created new product {}", productDTO);
                return "redirect:/myPage";
            }


            @GetMapping("/deleteProduct")
            public String showFormForDelete (@RequestParam("productId") Long id, Model model) throws IOException {
                productService.deleteProduct(id);
                List<ProductDTO> theProducts = productFacade.getAll();
                model.addAttribute("products", theProducts);
                return "my-page";
            }

            @GetMapping("/searchProduct")
            public String searchProductByName (@RequestParam("productName") String productName, Model model) throws NoResultException {
                List<Product> products = productService.findProductByName(productName);
                if (products.isEmpty()) {
                    return "error";
                }
                try {
                    model.addAttribute("products", products);
                    return "test";
                } catch (NoResultException e) {
                    System.out.println("Product with name {} not found" + productName );
                    return "error";
                }
            }

            @GetMapping("/getProduct")
            public String getProduct (@RequestParam("id") Long id, Model model){
                Product theProduct = productService.getProduct(id);
                try {
                    model.addAttribute("product", theProduct);
                    logger.info("Found product with id {}", id);
                    return "test";
                } catch (NullPointerException e) {
                   logger.info("Product with id {} not found", id);
                    return "error";
                }
            }

        }