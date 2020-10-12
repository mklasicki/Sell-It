package com.marcin.facades;

import com.marcin.dto.ProductDTO;
import org.springframework.validation.BindingResult;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

public interface ProductFacade {

    String validateAndRegisterNewProduct(ProductDTO productDTO, BindingResult result, Principal principal);

    List<ProductDTO> getAll() throws IOException;

}
