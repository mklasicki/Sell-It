package com.marcin.user;

import com.marcin.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlUserRepository extends JpaRepository<User, Long> {
}
