package com.marcin.service.impl;

import com.marcin.domain.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    @Test
    void getAll() {
    }

    @Test
    void saveUser() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
    }

    private List<User> generateTestData() {

        User user1 = new User(1L, "Marcin", "Klasicki","mar", "pass123", "marcin@klasicki.pl");
        User user2 = new User(2L, "Seba", "Kowalski","seb", "seba123", "typowy@seba.pl");
        User user3 = new User(3L, "Stefan", "Stefański","stef", "stef123", "stefan@stefanski.pl");

        return Arrays.asList(user1, user2, user3);
    }

}