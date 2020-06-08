package com.marcin.service.impl;

import com.marcin.daos.UserDao;
import com.marcin.domain.User;
import com.marcin.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao)
    {
        this.userDao = userDao;

    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User findUserById(long id) {
        return userDao.findUserById(id);
    }

    @Override
    public User findUserByName(String username) {
        return userDao.findUserByName(username);
    }


    @Override
    public boolean checkByUserName(String username) {
        return userDao.checkByUserName(username);
    }

    @Override
    public boolean checkByEmail(String email) {
        return userDao.checkByEmail(email);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}