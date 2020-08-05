package com.marcin.facades;

import com.marcin.dto.RegisterUserDTO;
import com.marcin.dto.UpdateUserDTO;
import com.marcin.dto.UserDTO;

import javax.mail.MessagingException;

public interface UserFacade {

     void registerNewUser(RegisterUserDTO registerUserDTO);

     void sendCredentialsMail(RegisterUserDTO registerUserDTO) throws MessagingException;

     void update(RegisterUserDTO registerUserDTO);

     RegisterUserDTO findUserByName(String name);

}
