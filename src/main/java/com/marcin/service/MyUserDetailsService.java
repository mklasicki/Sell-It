package com.marcin.service;

import com.marcin.daos.UserRepository;
import com.marcin.domain.MyUserPrincipal;
import com.marcin.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        MyUserPrincipal myUserPrincipal = new MyUserPrincipal(user);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return myUserPrincipal;
    }
}
