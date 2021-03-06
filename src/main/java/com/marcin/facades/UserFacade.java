package com.marcin.facades;


import com.marcin.domain.User;
import com.marcin.dto.UserDTO;
import org.springframework.validation.BindingResult;

import javax.mail.MessagingException;
import java.io.IOException;

public interface UserFacade {

     String validateAndRegisterNewUser(UserDTO userDTO, BindingResult result) throws MessagingException;

     UserDTO fillUserUpdateForm(Long id) throws IOException;

     void updateUser(Long id, UserDTO userDTO);

     void sendCredentialsMail(UserDTO userDTO) throws MessagingException;

     User findUserByName(String username);
}
