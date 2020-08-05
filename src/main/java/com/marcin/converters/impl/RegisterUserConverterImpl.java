package com.marcin.converters.impl;

import com.marcin.converters.Converter;
import com.marcin.domain.User;
import com.marcin.dto.RegisterUserDTO;
import com.marcin.dto.UpdateUserDTO;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RegisterUserConverterImpl implements Converter<RegisterUserDTO, User> {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final Logger log = LoggerFactory.getLogger(RegisterUserConverterImpl.class);


    @Override
    public User to(RegisterUserDTO registerUserDTO) {
        User user = new User();
        user.setId(registerUserDTO.getId());
        user.setUsername(registerUserDTO.getUsername());
        user.setSurname(registerUserDTO.getSurname());
        user.setLogin(registerUserDTO.getLogin());
        user.setGender(registerUserDTO.getGender());
        user.setPassword(encoder.encode(registerUserDTO.getPassword()));
        user.setEmail(registerUserDTO.getEmail());
        user.setEnabled(registerUserDTO.isEnabled());

        log.info("Konwersja z registerUserDTO {} na user {} ", registerUserDTO, user);

        return user;
    }

    @Override
    public RegisterUserDTO from(User user) {

        RegisterUserDTO registerUserDTO = new RegisterUserDTO();
        registerUserDTO.setUsername(user.getUsername());
        registerUserDTO.setSurname(user.getSurname());
        registerUserDTO.setEmail(user.getEmail());
        registerUserDTO.setPassword(user.getPassword());

        return registerUserDTO;
    }
}
