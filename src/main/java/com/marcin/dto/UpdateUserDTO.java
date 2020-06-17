package com.marcin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDTO {

    private String username;
    private String surname;
    private String email;
    private String password;

    @Override
    public String toString() {
        return "UpdateUserDTO{" +
                "username='" + username + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
