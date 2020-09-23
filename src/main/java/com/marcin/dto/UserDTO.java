package com.marcin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    @NotBlank(message = "To pole nie może być puste")
    @Size(min=3, max = 15, message = "Liczba znaków musi się zawierać miedzy 3 a 15")
    private String username;
    @NotBlank(message = "To pole nie może być puste")
    @Size(min=3, max = 15, message = "Liczba znaków musi się zawierać miedzy 3 a 15")
    private String lastName;
    @NotBlank(message = "To pole nie może być puste")
    @Size(min=3, max = 15, message = "Liczba znaków musi się zawierać miedzy 3 a 15")
    private String login;
    @NotBlank(message = "To pole nie może być puste")
    @Size(min=3, max = 15, message = "Liczba znaków musi się zawierać miedzy 3 a 15")
    private String password;
    @NotBlank(message = "To pole nie może być puste")
    @Email(message = "Wprowadzone dane są nieprawidłowe")
    private String email;
    @AssertTrue(message = "Aby się zarejestrowac musisz zaakceptować regulamin")
    private boolean enabled;
    private String authority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
