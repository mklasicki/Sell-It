package com.marcin.service.impl;

import com.marcin.daos.UserDao;
import com.marcin.domain.Authorities;
import com.marcin.domain.Category;
import com.marcin.domain.Product;
import com.marcin.domain.User;
import com.marcin.dto.RegisterProductDTO;
import com.marcin.dto.RegisterUserDTO;
import com.marcin.service.AuthoritiesService;
import com.marcin.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private AuthoritiesService authoritiesService;

    public UserServiceImpl(UserDao userDao, AuthoritiesService authoritiesService) {
        this.userDao = userDao;
        this.authoritiesService = authoritiesService;
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
        return null;
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
}