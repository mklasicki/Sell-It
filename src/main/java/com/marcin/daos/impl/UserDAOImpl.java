package com.marcin.daos.impl;

import com.marcin.daos.UserDao;
import com.marcin.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class UserDAOImpl implements UserDao {

    private EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveUser(User newUser) {
        entityManager.persist(newUser);
    }


}


