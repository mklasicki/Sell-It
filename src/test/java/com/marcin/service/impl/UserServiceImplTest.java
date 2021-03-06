package com.marcin.service.impl;


import com.marcin.repositories.UserRepository;
import com.marcin.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private final long USER_ID = 1L;
    private final String NAME = "Marcin";

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void should_return_list_of_all_the_users() {

        //given
        List<User> users = generateTestData();
        when(userRepository.findAll()).thenReturn(users);

        //when
        List<User> userResultList = userService.getAll();

        //then
        assertThat(users, hasSize(3));
        assertNotNull(userResultList);
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void should_add_new_user() {

        //given
        User user1 = new User(USER_ID, "Marcin", "Klasicki","mar", "pass123", "marcin@klasicki.pl");
        when(userRepository.save(user1)).thenReturn(user1);

        //when
        userService.saveUser(user1);

        //then
        verify(userRepository, times(1)).save(user1);



    }

    @Test
    void should_return_user_when_given_id() {

        //given
        Optional<User> user = Optional.of(new User(USER_ID, "Marcin", "Klasicki","mar", "pass123", "marcin@klasicki.pl"));
        when(userRepository.findById(USER_ID)).thenReturn(user);

        //when
        Optional<User> userResult = userService.findById(USER_ID);


        //than
        assertThat(userResult, equalTo(user));
        verify(userRepository, times(1)).findById(any());
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