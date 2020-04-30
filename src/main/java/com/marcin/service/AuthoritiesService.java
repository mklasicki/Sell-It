package com.marcin.service;

import com.marcin.domain.Authorities;
import com.marcin.dto.RegisterAuthoritiesDTO;


import java.util.List;

public interface AuthoritiesService {

    List<Authorities> getAll();

    void save(Authorities authorities);

    Authorities findById(long id);

    void registerNewAuthority(RegisterAuthoritiesDTO registerAuthoritiesDTO);

}
