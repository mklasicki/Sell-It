package com.marcin.repositories;

import java.util.Optional;

import com.marcin.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByNameAndLastName(String name, String lastName);


}
