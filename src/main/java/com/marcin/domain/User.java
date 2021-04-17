package com.marcin.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String login;
    private String password;
    private String email;
    private boolean enabled;
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REFRESH,
            CascadeType.DETACH, CascadeType.MERGE})
    private List<Product> products;
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REFRESH,
            CascadeType.DETACH, CascadeType.MERGE})
    private List<Authorities> roles;

    public User(Long id, String name, String lastName, String login, String password, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return isEnabled() == user.isEnabled() &&
            Objects.equals(getId(), user.getId()) &&
            Objects.equals(getName(), user.getName()) &&
            Objects.equals(getLastName(), user.getLastName()) &&
            Objects.equals(getLogin(), user.getLogin()) &&
            Objects.equals(getPassword(), user.getPassword()) &&
            Objects.equals(getEmail(), user.getEmail()) &&
            Objects.equals(getProducts(), user.getProducts()) &&
            Objects.equals(getRoles(), user.getRoles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLastName(), getLogin(), getPassword(), getEmail(), isEnabled(), getProducts(), getRoles());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + name + '\'' +
                ", surname='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", roles=" + roles +
                '}';
    }
}


