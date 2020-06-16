package com.marcin.daos;

import com.marcin.domain.User;

import java.util.List;

public interface UserDao {

    List<User> getAll();

    void saveUser(User newUser);

    void updateUser(User user);

    User findUserById(Long id);

    User findUserByName(String username);

    boolean checkByUserName(String username);

    boolean checkByEmail(String email);

}
