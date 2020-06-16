package com.marcin.converters.impl;


import com.marcin.converters.Converter;
import com.marcin.domain.User;
import com.marcin.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
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
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(encoder.encode(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());
        user.setEnabled(userDTO.isEnabled());

        log.info("Konwersja z userDTO {} na user {} ", userDTO, user);

        return user;

    }

    @Override
    public UserDTO from(User user) {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());



        log.info("Konwersja z user {} na userDTO {}", user, userDTO);

        return userDTO;
    }
}
