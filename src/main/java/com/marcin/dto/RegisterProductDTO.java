package com.marcin.dto;

<<<<<<< HEAD

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
=======
public class RegisterProductDTO {

    private String name;
    private String category;
    private String description;
    private Float price;
    private String imageUrl;
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed

    public RegisterProductDTO() {
    }

<<<<<<< HEAD
    public RegisterProductDTO(String name, String category, String description, Float price, MultipartFile image,
                              Principal principal) {
=======
    public RegisterProductDTO(String name, String category, String description, Float price, String imageUrl) {
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
<<<<<<< HEAD
        this.image = image;
        this.principal = principal;
=======
        this.imageUrl = imageUrl;
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed
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

<<<<<<< HEAD
    public Float getPrice() { return price; }
=======
    public Float getPrice() {
        return price;
    }
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed

    public void setPrice(Float price) {
        this.price = price;
    }

<<<<<<< HEAD
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
=======
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed
    }
}
