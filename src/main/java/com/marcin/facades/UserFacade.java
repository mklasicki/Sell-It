package com.marcin.facades;

import com.marcin.dto.UserDTO;

import javax.mail.MessagingException;

public interface UserFacade {

     void registerNewUser(UserDTO userDTO);

     void sendCredentialsMail(UserDTO userDTO) throws MessagingException;

     UserDTO getUserById(Long id);

     void update(UserDTO userDTO);

}
