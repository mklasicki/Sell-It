package com.marcin.domain;

import javax.persistence.*;
<<<<<<< HEAD
import javax.validation.constraints.NotNull;
=======
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "To pole nie może być puste")
    private String productName;
<<<<<<< HEAD
    @NotNull(message = "To Pole nie może byc puste")
    private float productPrice;
    private String productDescription;
    private String image;
    @OneToOne(cascade  = {CascadeType.PERSIST, CascadeType.REFRESH,
            CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(columnDefinition = "user_id")
=======
    private float productPrice;
    private String productDescription;
    private String image;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH,
            CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed
    private User user;

    public Product() {
    }

    public boolean isNew() {
        return id == 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

<<<<<<< HEAD
    public void setImage(String image) {
        this.image = image;
    }

=======
>>>>>>> d9c827b3bd82bc443da06eac34eb78633448d4ed
    public String getImage() {
        return image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
