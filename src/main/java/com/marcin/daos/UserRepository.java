package com.marcin.daos;

import java.util.Optional;

import com.marcin.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByFirstNameAndLastName(String firstName, String lastName);

}
