package com.marcin.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class UserSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private LocalDate timeStamp;

    public UserSession(Long userId, LocalDate timeStamp) {
        this.userId = userId;
        this.timeStamp = timeStamp;
    }

    public UserSession() {
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

}
