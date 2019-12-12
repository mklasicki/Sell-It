package com.marcin.service.impl;

import com.marcin.daos.UserDao;
import com.marcin.domain.User;
import com.marcin.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void saveUser(User newUser) {
        if (newUser.isNew()) {
            userDao.saveUser(newUser);
        }
    }
}