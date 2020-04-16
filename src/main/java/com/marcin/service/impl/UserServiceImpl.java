package com.marcin.service.impl;

import com.marcin.daos.UserDao;
import com.marcin.domain.User;
import com.marcin.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void saveUser(User newUser) {
        if (newUser.isNew()) {
            String pass = newUser.getPassword();
            newUser.setPassword(passwordEncoder.encode(pass));
            userDao.saveUser(newUser);
        }
    }

    @Override
    public User findUserByName(String username) {
        return null;
    }
}