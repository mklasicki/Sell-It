package com.marcin.facades.impl;


import com.marcin.converters.Converter;
import com.marcin.domain.Authorities;
import com.marcin.domain.User;
import com.marcin.dto.UserDTO;
import com.marcin.facades.UserFacade;
import com.marcin.service.AuthoritiesService;
import com.marcin.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;
    private final AuthoritiesService authoritiesService;
    private final Converter converter;


    @Override
    public void registerNewUser(UserDTO userDTO) {

        Authorities authority = new Authorities();
        User user = createUserForm(userDTO, authority);
        userService.saveUser(user);
    }

    User createUserForm(UserDTO userDTO, Authorities authorities) {

        User user = (User) converter.to(userDTO);
        authorities.setAuthority("ROLE_USER");
        authorities.setUsername(user.getUsername());
        user.addAuthority(authorities);
        return user;
    }

}
