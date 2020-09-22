package com.marcin.service.impl;


import com.marcin.daos.UserSessionDAO;
import com.marcin.domain.UserSession;
import com.marcin.service.UserSessionService;
import org.springframework.stereotype.Service;

@Service
public class UserSessionServiceImpl implements UserSessionService {

    private UserSessionDAO userSessionDAO;

    public UserSessionServiceImpl(UserSessionDAO userSessionDAO) {
        this.userSessionDAO = userSessionDAO;
    }

    @Override
    public void save(UserSession userSession) {
        userSessionDAO.save(userSession);
    }
}
