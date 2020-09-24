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

        User user = new User();
        user.setName(userDTO.getUsername());
        user.setLastName(userDTO.getLastName());
        user.setPassword(encoder.encode(userDTO.getPassword()));
        user.setLogin(userDTO.getLogin());
        user.setEmail(userDTO.getEmail());
        user.setEnabled(userDTO.isEnabled());

        log.info("Conversion from  userDTO {} to user {} ", userDTO, user);

        return user;

    }

    @Override
    public UserDTO from(User user) {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setUsername(user.getName());
        userDTO.setPassword(user.getPassword());

        log.info("Conversion {} from  userDTO {}", user, userDTO);

        return userDTO;
    }

    @Override
    public List<UserDTO> listConverter(List<User> users) {
        return null;
    }
}
