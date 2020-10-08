package com.marcin.converters.impl;


import com.marcin.converters.Converter;
import com.marcin.domain.User;
import com.marcin.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserConverterImpl implements Converter<UserDTO, User> {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final Logger log = LoggerFactory.getLogger(UserConverterImpl.class);


    @Override
    public User to(UserDTO userDTO) {

        log.info("Converting UserDTO to User");

        return new User(
                userDTO.getId(),
                userDTO.getUsername(),
                userDTO.getLastName(),
                userDTO.getLogin(),
                encoder.encode(userDTO.getPassword()),
                userDTO.getEmail());
    }

    @Override
    public UserDTO from(User user) {

        log.info("Converting User to UserDTO");

        return new UserDTO(user.getId(),
                user.getName(),
                user.getLastName(),
                user.getPassword(),
                user.getEmail());
    }

    @Override
    public List<UserDTO> listConverter(List<User> users) {
        return null;
    }
}
