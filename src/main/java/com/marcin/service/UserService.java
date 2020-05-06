package com.marcin.service;

import com.marcin.domain.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    List<User> getAll();

    User findUserByName(String username);

    User findUserById(long id);

    boolean checkByUserName(String username);

    boolean checkByEmail(String email);
}
