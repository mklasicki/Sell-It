package com.marcin.daos.impl;

import com.marcin.daos.UserDao;
import com.marcin.domain.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
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
    public List<User> getAll() {
        TypedQuery<User> query = entityManager.createQuery("from User u ", User.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void saveUser(User user)  {
        List<User> users = getAll();

        if (users.isEmpty()) {
            System.out.println("Nie ma takiego usera, można go zapisać");
            entityManager.persist(user);
            System.out.println("Zapisano nowego usera " + user.getUsername());
        } else if (checkByUserName(user.getUsername())) {
            System.out.println("User o imieniu " + user.getUsername() + " juz istnieje, nie można go zapisać");
        } else if (checkByEmail(user.getEmail())) {
            System.out.println("Adres mail " + user.getEmail() + " juz istnieje w bazie danych, nie można zapisać");
        } else {
            System.out.println("Nie ma takiego usera, można go zapisać");
            entityManager.persist(user);
            System.out.println("Zapisano nowego usera " + user.getUsername());
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
            System.out.println("Brak wyników wyszukiwania");
        }

       if(user != null) {
           return true;
       }
        return false;
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
            System.out.println("Brak wyników wyszukiwania");
        }
        if(user != null) {
            return true;
        }
        return false;
    }
}





