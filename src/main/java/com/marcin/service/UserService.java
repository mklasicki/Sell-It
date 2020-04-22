package com.marcin.service;

import com.marcin.domain.User;
import com.marcin.dto.RegisterUserDTO;

public interface UserService {

    void saveUser(User newUser);

    User findUserByName(String username);

    void registerNewUser(RegisterUserDTO registerUserDTO);

    User findUserById(long id);
}
