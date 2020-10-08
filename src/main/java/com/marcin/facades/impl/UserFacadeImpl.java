package com.marcin.facades.impl;


import com.marcin.converters.Converter;
import com.marcin.domain.Authorities;
import com.marcin.domain.User;
import com.marcin.dto.UserDTO;
import com.marcin.facades.UserFacade;
import com.marcin.service.MailService;
import com.marcin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;


import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;


@Service
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;
    private final Converter<UserDTO, User> converter;
    private final MailService mailService;
    private final Logger log = LoggerFactory.getLogger(UserFacadeImpl.class);

    public UserFacadeImpl(UserService userService,
                          @Qualifier("userConverterImpl") Converter<UserDTO, User> converter,
                          MailService mailService) {
        this.userService = userService;
        this.converter = converter;
        this.mailService = mailService;
    }

    @Override
    public String validateAndRegisterNewUser(UserDTO userDTO, BindingResult result) throws MessagingException {

        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors) {
                log.info("Can't  register new user, errors occurred during filling form {}", error);
            }
            return "register-user-form";
        } else {
            Authorities authority = new Authorities();
            User user = createUserForm(userDTO, authority);
            userService.saveUser(user);
            sendCredentialsMail(userDTO);

            log.info("created new user {} sent email on address {}", userDTO.getUsername(), userDTO.getEmail());

            return "register-success-page";
        }
    }

    User createUserForm(UserDTO userDTO, Authorities authorities) {

        User user = converter.to(userDTO);
        authorities.setAuthority("ROLE_USER");
        authorities.setUsername(user.getName());
        user.addAuthority(authorities);
        user.setEnabled(true);
        return user;
    }

    @Override
    public UserDTO fillUserUpdateForm(Long id) throws IOException {
        User user = userService.findById(id).orElse(null);
        UserDTO userDTO = converter.from(user);
        return userDTO;
    }

    @Override
    public void updateUser(Long id, UserDTO userDTO) {
        userService.updateUser(id, userDTO);
    }

    @Override
    public void sendCredentialsMail(UserDTO userDTO) throws MessagingException {

        mailService.SendMail(userDTO.getEmail(), "Potwierdzenie utworzenia konta",
                "" + "<h2>Twoje dane do logowania to : </h2>"
                        + "<p>Login: </p>"
                        + userDTO.getUsername()
                        + "<p>Hasło: </p>"
                        + userDTO.getPassword(), true);
    }


}
