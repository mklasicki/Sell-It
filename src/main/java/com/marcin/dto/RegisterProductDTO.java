package com.marcin.dto;


import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.security.Principal;

public class RegisterProductDTO {

    @NotNull(message = "To pole nie może być puste.")
    private String name;
    private String category;
    private String description;
    @NotNull(message = "To pole nie może być puste")
    private Float price;
    private MultipartFile image;
    private Principal principal;

    public RegisterProductDTO() {
    }

    public RegisterProductDTO(String name, String category, String description, Float price, MultipartFile image,
                              Principal principal) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.image = image;
        this.principal = principal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() { return price; }

    public void setPrice(Float price) {
        this.price = price;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }
}
