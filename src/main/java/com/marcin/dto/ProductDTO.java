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
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;
    @NotBlank(message = "To pole nie może byc puste")
    private String productName;
    private String category;
    @NotBlank(message = "To pole nie może być puste")
    @Size(max=300,message = "Liczba znaków nie może być wieksza niż 250")
    private String productDescription;
    @NotNull(message = "To pole nie może być puste")
    private Float productPrice;
    private MultipartFile image;
    private Principal principal;
    private String imageName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return productName;
    }

    public void setName(String name) {
        this.productName = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDTO)) return false;
        ProductDTO that = (ProductDTO) o;
        return Objects.equals(getId(), that.getId()) &&
            Objects.equals(getProductName(), that.getProductName()) &&
            Objects.equals(getCategory(), that.getCategory()) &&
            Objects.equals(getProductDescription(), that.getProductDescription()) &&
            Objects.equals(getProductPrice(), that.getProductPrice()) &&
            Objects.equals(getImage(), that.getImage()) &&
            Objects.equals(getPrincipal(), that.getPrincipal()) &&
            Objects.equals(getImageName(), that.getImageName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProductName(), getCategory(), getProductDescription(), getProductPrice(), getImage(), getPrincipal(), getImageName());
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                ", name='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", description='" + productDescription + '\'' +
                ", price=" + productPrice +
                ", image=" + image +
                ", principal=" + principal +
                '}';
    }
}
