package com.marcin.converters.impl;


import com.marcin.converters.Converter;
import com.marcin.domain.User;
import com.marcin.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserConverterImpl implements Converter<UserDTO, User> {

    private final Logger log = LoggerFactory.getLogger(UserConverterImpl.class);


    @Override
    public User to(UserDTO userDTO) {
        User user = new User();



        log.info("Konwersja z user {} na userDTO {} ", user, userDTO);

        return user;


    }

    @Override
    public UserDTO from(User user) {
        return null;
    }
}
