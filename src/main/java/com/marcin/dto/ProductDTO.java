package com.marcin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.security.Principal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;
    @NotBlank(message = "To pole nie może byc puste")
    private String name;
    private String category;
    @NotBlank(message = "To pole nie może być puste")
    @Size(max=300,message = "Liczba znaków nie może być wieksza niż 250")
    private String description;
    @NotNull(message = "To pole nie może być puste")
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
