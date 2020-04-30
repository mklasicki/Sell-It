package com.marcin.service.impl;

import com.marcin.daos.AuthoritiesDAO;
import com.marcin.domain.Authorities;
import com.marcin.dto.RegisterAuthoritiesDTO;
import com.marcin.service.AuthoritiesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {

    private final AuthoritiesDAO authoritiesDAO;

    public AuthoritiesServiceImpl(AuthoritiesDAO authoritiesDAO) {
        this.authoritiesDAO = authoritiesDAO;
    }

    @Override
    @Transactional
    public List<Authorities> getAll() {
        return authoritiesDAO.getAuthorities();
    }

    @Override
    @Transactional
    public void save(Authorities authorities) {
        authoritiesDAO.saveAuthorities(authorities);
    }

    @Override
    @Transactional
    public Authorities findById(long id) {
        return authoritiesDAO.findAuthorities(id);
    }

    @Override
    public void registerNewAuthority(RegisterAuthoritiesDTO registerAuthoritiesDTO) {

    }
}
