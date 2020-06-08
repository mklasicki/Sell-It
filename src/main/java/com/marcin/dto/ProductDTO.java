package com.marcin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private String category;
    private String description;
    private Float price;
    private MultipartFile image;
    private Principal principal;

    @Override
    public String toString() {
        return "ProductDTO{" +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image=" + image +
                ", principal=" + principal +
                '}';
    }
}
