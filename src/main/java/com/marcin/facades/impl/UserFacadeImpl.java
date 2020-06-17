package com.marcin.facades.impl;


import com.marcin.converters.Converter;
import com.marcin.domain.Authorities;
import com.marcin.domain.User;
import com.marcin.dto.RegisterUserDTO;
import com.marcin.dto.UpdateUserDTO;
import com.marcin.dto.UserDTO;
import com.marcin.facades.UserFacade;
import com.marcin.service.AuthoritiesService;
import com.marcin.service.MailService;
import com.marcin.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;
    private final AuthoritiesService authoritiesService;
    private final Converter converter;
    private final MailService mailService;

    public UserFacadeImpl(UserService userService, AuthoritiesService authoritiesService
            , @Qualifier("registerUserConverterImpl") Converter converter, MailService mailService) {
        this.userService = userService;
        this.authoritiesService = authoritiesService;
        this.converter = converter;
        this.mailService = mailService;
    }

    @Override
    public void registerNewUser(RegisterUserDTO registerUserDTO) {

        Authorities authority = new Authorities();
        User user = createUserForm(registerUserDTO, authority);
        userService.saveUser(user);
    }

    User createUserForm(RegisterUserDTO registerUserDTO, Authorities authorities) {

        User user = (User) converter.to(registerUserDTO);
        authorities.setAuthority("ROLE_USER");
        authorities.setUsername(user.getUsername());
        user.addAuthority(authorities);
        return user;
    }

    @Override
    public void sendCredentialsMail(RegisterUserDTO registerUserDTO) throws MessagingException {
        mailService.SendMail(registerUserDTO.getEmail(), "Potwierdzenie stworzenia konta",
                "" + "<h2>Twoje dane do logowania to : </h2>"
                        + "<p>Login: </p>"
                        + registerUserDTO.getUsername()
                        + "<p>Hasło: </p>"
                        + registerUserDTO.getPassword(), true);
    }

    @Override
    public UpdateUserDTO getUserById(Long id) {
        User user = userService.findUserById(id);
        UpdateUserDTO updateUserDTO = (UpdateUserDTO) converter.from(user);
        return updateUserDTO;
    }

    @Override
    public void update( UpdateUserDTO updateUserDTO) {
        User user = (User) converter.to(updateUserDTO);
        userService.updateUser(user);
    }
}
