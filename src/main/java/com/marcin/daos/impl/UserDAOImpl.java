package com.marcin.daos.impl;

import com.marcin.daos.UserDao;
import com.marcin.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDao {

    private final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);

    private final EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAll() {
        TypedQuery<User> query = entityManager.createQuery("from User u ", User.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        List<User> users = getAll();

        if (users.isEmpty()) {
            log.info("Nie ma takiego usera, można go zapisać");
            entityManager.persist(user);
            log.info("Zapisano nowego usera {}", user.getUsername());
        } else if (checkByUserName(user.getUsername())) {
            log.info("User o imieniu {} juz istnieje, nie można go zapisać", user.getUsername());
        } else if (checkByEmail(user.getEmail())) {
            log.info("Adres mail {} juz istnieje w bazie danych, nie można zapisać", user.getEmail());
        } else {
            log.info("Nie ma takiego usera, można go zapisać");
            entityManager.persist(user);
            log.info("Zapisano nowego usera {}", user.getUsername());
        }
    }

    @Override
    public User findUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User findUserByName(String username) {
        User user = (User) entityManager.createQuery(
                "select u " +
                        "from User u  " +
                        "where u.username like :username")
                .setParameter("username", username)
                .getSingleResult();
        return user;
    }

    @Override
    public boolean checkByUserName(String username) {
        User user = null;
        try {
            user = (User) entityManager.createQuery(
                    "select u " +
                            "from User u  " +
                            "where u.username like :username")
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            log.info("Brak wyników wyszukiwania");
        }

        return user != null;
    }

    @Override
    public boolean checkByEmail(String email) {
        User user = null;
        try {
            user = (User) entityManager.createQuery(
                    "select u " +
                            "from User u  " +
                            "where u.email like : email ")
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            log.info("Brak wyników wyszukiwania");
        }
        return user != null;
    }
}





