package com.marcin.service;

import com.marcin.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService  {

    void saveUser(User user);

    List<User> getAll();

    Optional<User> findById(long id);

    User findByName(String name);

}
