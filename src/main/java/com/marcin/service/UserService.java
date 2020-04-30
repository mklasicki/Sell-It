package com.marcin.service;

import com.marcin.domain.User;
import com.marcin.dto.RegisterUserDTO;

import java.util.List;

public interface UserService {

    void saveUser(User newUser);

    List<User> getAll();

    User findUserByName(String username);

    void registerNewUser(RegisterUserDTO registerUserDTO);

    User findUserById(long id);

    boolean checkByUserName(String username);

    boolean checkByEmail(String email);
}
