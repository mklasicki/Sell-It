package com.marcin.facades;

import com.marcin.dto.ProductDTO;
import org.springframework.validation.BindingResult;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

public interface ProductFacade {

    String validateAndRegisterNewProduct(ProductDTO productDTO, BindingResult result, Principal principal);

    List<ProductDTO> getAll() throws IOException;

    void deleteById(Long id);

     List<ProductDTO> searchProductsByName(String productName) throws IOException;

     List<ProductDTO> getProductsByCategory(String category) throws IOException;

     List<ProductDTO> getProductsByUserId(Long id) throws IOException;

}
