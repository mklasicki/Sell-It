package com.marcin.daos;

import com.marcin.domain.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSessionDAO extends JpaRepository<UserSession, Long> {
}
