package com.marcin.service;

import com.marcin.domain.User;
import com.marcin.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService  {

    void saveUser(User user);

    List<User> getAll();

    User findById(long id);

    User findByName(String name);

    User findUserByLogin(String login);

    void updateUser(Long id, UserDTO userDTO);

    boolean isEmailTaken(String email);

    boolean isUsernameTaken(String username);

}
