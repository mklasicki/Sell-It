package com.marcin.daos.impl;

import com.marcin.daos.UserDao;
import com.marcin.domain.Product;
import com.marcin.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDao {

    private EntityManager entityManager;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDAOImpl(EntityManager entityManager, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.entityManager = entityManager;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        String pass = user.getPassword();
        System.out.println("zapisane hasło to " + pass);
      //  String encodedPass = bCryptPasswordEncoder.encode(pass);
      //  System.out.println("Hasło zahashowane to " + encodedPass);
        user.setEnabled(true);
    //    user.setPassword(encodedPass);
        entityManager.persist(user);
    }

    @Override
    public User findUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User findUserByName(String username) {
        User user =(User) entityManager.createQuery(
                "select u " +
                        "from User u  " +
                        "where u.username like :username")
                .setParameter("username", username)
                .getSingleResult();
        return user;
    }
}





