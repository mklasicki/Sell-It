package com.marcin.dto;

import com.marcin.validaton.annotation.UniqueEmail;
import com.marcin.validaton.annotation.UniqueUsername;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;
    @NotBlank(message = "Pole imię nie może byc puste")
    private String username;
    @NotBlank(message = "Pole nazwisko nie może być puste")
    private String lastName;
    @NotBlank(message = "Pole login nie może być puste")
    @UniqueUsername(message = "Podany login jest już zajęty")
    private String login;
    @NotBlank(message = "Pole hasło nie może być puste")
    private String password;
    @NotBlank(message = "Pole e-mail nie może być puste")
    @Email(message = "Wprowadzone dane są nieprawidłowe")
    @UniqueEmail(message = "Podany e-mail jest już zajęty")
    private String email;
    @AssertTrue(message = "Aby się zarejestrowac musisz zaakceptować regulamin")
    private boolean enabled;
    private String authority;

    public UserDTO(Long id, String username, String lastName, String password, String email) {
        this.id = id;
        this.username = username;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

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
