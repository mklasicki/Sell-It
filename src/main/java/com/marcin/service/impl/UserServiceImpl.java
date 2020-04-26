package com.marcin.service.impl;

import com.marcin.daos.UserDao;
import com.marcin.domain.Authorities;
import com.marcin.domain.User;
import com.marcin.dto.RegisterUserDTO;
import com.marcin.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    @Transactional
    public void saveUser(User newUser) {
        if (newUser.isNew()) {
            userDao.saveUser(newUser);
        }
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
    public void registerNewUser(RegisterUserDTO registerUserDTO) {
        Authorities authority = new Authorities();
        User user = createUserFrom(registerUserDTO, authority);
        userDao.saveUser(user);
    }

    private User createUserFrom(RegisterUserDTO registerUserDTO, Authorities authorities) {
        User user = new User();
        user.setUsername(registerUserDTO.getUsername());
        user.setPassword(registerUserDTO.getPassword());
        user.setEmail(registerUserDTO.getEmail());
        user.setEnabled(true);
        authorities.setAuthority("ROLE_USER");
        authorities.setUsername(user.getUsername());
        authorities.setUser(user);
        user.addAuthority(authorities);
        return user;
    }

    @Override
    public boolean checkByUserName(String username) {
        return userDao.checkByUserName(username);
    }

    @Override
    public boolean checkByEmail(String email) {
        return userDao.checkByEmail(email);
    }
}