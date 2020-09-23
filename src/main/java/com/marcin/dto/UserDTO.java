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
    private String userName;
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


}
