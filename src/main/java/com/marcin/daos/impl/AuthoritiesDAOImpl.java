package com.marcin.daos.impl;

import com.marcin.daos.AuthoritiesDAO;
import com.marcin.domain.Authorities;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class AuthoritiesDAOImpl implements AuthoritiesDAO {

    private final EntityManager entityManager;

    public AuthoritiesDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Authorities> getAuthorities() {
        return entityManager.createQuery("select a from Authorities a", Authorities.class).getResultList();
    }

    @Override
    public void saveAuthorities(Authorities authorities) {
            entityManager.persist(authorities);
    }

    @Override
    public Authorities findAuthorities(long id) {
        return entityManager.find(Authorities.class, id);
    }
}
