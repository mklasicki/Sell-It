package com.marcin.service;

import com.marcin.domain.User;

public interface UserService {

    void saveUser(User newUser);

    User findUserByName(String username);
}
