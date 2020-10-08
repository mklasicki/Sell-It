package com.marcin.facades;


import com.marcin.dto.UserDTO;
import org.springframework.validation.BindingResult;

import javax.mail.MessagingException;

public interface UserFacade {

     String validateAndRegisterNewUser(UserDTO userDTO, BindingResult result) throws MessagingException;

     void sendCredentialsMail(UserDTO userDTO) throws MessagingException;


}
