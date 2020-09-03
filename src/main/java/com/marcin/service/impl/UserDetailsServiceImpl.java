package com.marcin.service.impl;

import com.marcin.domain.User;
import com.marcin.dto.UserDetailsDTO;
import com.marcin.exceptions.UserNotFoundException;
import com.marcin.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UserNotFoundException {
        User user = userService.findUserByName(userName);

        if (user == null) {
            throw new UserNotFoundException("User with name " + userName + " not found");
        }

        return new UserDetailsDTO(user);
    }
}
