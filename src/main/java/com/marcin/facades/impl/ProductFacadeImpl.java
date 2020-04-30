package com.marcin.facades.impl;

<<<<<<< HEAD

=======
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed
import com.marcin.dto.RegisterProductDTO;
import com.marcin.facades.ProductFacade;
import com.marcin.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductFacadeImpl implements ProductFacade {

    private final ProductService productService;

    public ProductFacadeImpl(ProductService productService) {
        this.productService = productService;
<<<<<<< HEAD

=======
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed
    }

    @Override
    public void registerNewProduct(RegisterProductDTO registerProductDTO) {
        productService.registerNewProduct(registerProductDTO);
    }
<<<<<<< HEAD

=======
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed
}
