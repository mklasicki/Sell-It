package com.marcin.dto;


public class RegisterProductDTO {

    private String name;
    private String category;
    private String description;
    private Float price;
    private String image;

    public RegisterProductDTO() {
    }

    public RegisterProductDTO(String name, String category, String description, Float price, String image) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
