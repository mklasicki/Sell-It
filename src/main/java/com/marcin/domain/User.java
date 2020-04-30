package com.marcin.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String email;
    private boolean enabled;
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REFRESH,
            CascadeType.DETACH, CascadeType.MERGE})
    private List<Product> products;
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REFRESH,
            CascadeType.DETACH, CascadeType.MERGE})
    private List<Authorities> roles;


    public User() {
        // needed by Hibernate
    }

    public boolean isNew() {
        return id == 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        if (products == null) {
            products = new ArrayList<>();
        }

        products.add(product);
        product.setUser(this);
    }

    public void setRoles(List<Authorities> roles) {
        this.roles = roles;
    }

    public List<Authorities> getRoles() {
        return roles;
    }

    public void addAuthority(Authorities authority) {
        if (roles == null) {
            roles = new ArrayList<>();
        }

        roles.add(authority);
        authority.setUser(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password=[PROTECTED]" + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", products=" + products +
                ", roles=" + roles +
                '}';
    }
}


