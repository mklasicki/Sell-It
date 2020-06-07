package com.marcin.converters.impl;


import com.marcin.converters.Converter;
import com.marcin.domain.User;
import com.marcin.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
 @AllArgsConstructor
public class UserConverterImpl implements Converter<UserDTO, User> {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final Logger log = LoggerFactory.getLogger(UserConverterImpl.class);


    @Override
    public User to(UserDTO userDTO) {

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(encoder.encode(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());
        user.setEnabled(userDTO.isEnabled());

        log.info("Konwersja z user {} na userDTO {} ", user, userDTO);

        return user;

    }

    @Override
    public UserDTO from(User user) {
        return null;
    }
}
