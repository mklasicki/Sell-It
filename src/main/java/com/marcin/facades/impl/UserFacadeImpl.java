package com.marcin.facades.impl;



import com.marcin.dto.RegisterUserDTO;
import com.marcin.facades.UserFacade;
import com.marcin.service.AuthoritiesService;
import com.marcin.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;
    private final AuthoritiesService authoritiesService;

    public UserFacadeImpl(UserService userService, AuthoritiesService authoritiesService) {
        this.userService = userService;
        this.authoritiesService = authoritiesService;
    }

    @Override
    public void registerNewUser(RegisterUserDTO registerUserDTO) {
        userService.registerNewUser(registerUserDTO);
    }
}
