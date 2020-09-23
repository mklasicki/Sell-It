package com.marcin.facades;

import com.marcin.dto.RegisterUserDTO;

import javax.mail.MessagingException;

public interface UserFacade {

     void registerNewUser(RegisterUserDTO registerUserDTO);

     void sendCredentialsMail(RegisterUserDTO registerUserDTO) throws MessagingException;


}
