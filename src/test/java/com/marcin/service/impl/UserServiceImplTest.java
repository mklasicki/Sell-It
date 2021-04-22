package com.marcin.service.impl;


import com.marcin.exceptions.DataNotFoundException;
import com.marcin.exceptions.UserNotFoundException;
import com.marcin.repositories.UserRepository;
import com.marcin.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private final long USER_ID = 1L;
    private User user;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;


    @BeforeEach
    void setup() {
        user = User.builder()
            .id(USER_ID)
            .name("Marcin")
            .lastName("Klasicki")
            .password("pass123")
            .login("mar")
            .email("marcin@klasicki.pl")
            .build();
    }

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
    void should_throw_DataNotFoundException_when_list_of_all_users_is_empty() {

        //given
        List<User> users = Collections.emptyList();

        //when
        when(userRepository.findAll()).thenReturn(users);

        //then
        assertThat(users, is(empty()));
        assertThrows(DataNotFoundException.class, () -> userService.getAll());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void should_add_new_user() {

        //given
        when(userRepository.save(user)).thenReturn(user);
        when(userRepository.existsById(user.getId())).thenReturn(true);
        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);

        //when
        userService.saveUser(user);
        boolean doExist = userRepository.existsById(USER_ID);

        //then
        verify(userRepository).save(argumentCaptor.capture());
        User addedUser = argumentCaptor.getValue();
        assertThat(addedUser, is(user));
        assertTrue(doExist);
    }

    @Test
    void should_return_user_when_given_id() {

        //given
        when(userRepository.findById(USER_ID)).thenReturn(Optional.of(user));
        when(userRepository.existsById(USER_ID)).thenReturn(true);

        //when
        User userResult = userService.findById(USER_ID);
        boolean doExists = userRepository.existsById(USER_ID);

        //then
        assertThat(userResult.getName(), is(user.getName()));
        assertTrue(doExists);
        verify(userRepository, times(1)).findById(USER_ID);
    }

    @Test
    void should_throw_UserNotFoundException_when_user_not_found_by_id() {

        //given
        //when
        when(userRepository.findById(USER_ID)).thenReturn(Optional.empty());

        //then
        assertThrows(UserNotFoundException.class, () -> userService.findById(USER_ID));
        verify(userRepository, times(1)).findById(any());
    }

    @Test
    void should_return_user_when_given_name() {

        //given
        when(userRepository.findAll()).thenReturn(generateTestData());
        User testUser = generateTestData().get(0);
        String userName = "Marcin";

        //when
        User searchResult = userService.findByName(userName);

        //then
        assertThat(searchResult.getName(), is(testUser.getName()));
        assertThat(searchResult, is(testUser));
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void should_return_user_when_given_login() {

        //given
        when(userRepository.findAll()).thenReturn(generateTestData());
        User testUser = generateTestData().get(1);
        String userLogin = "seb";

        //when
        User searchResult = userService.findUserByLogin(userLogin);

        //then
        assertThat(searchResult.getName(), is(testUser.getName()));
        assertThat(searchResult, is(testUser));
        verify(userRepository, times(1)).findAll();
    }

    private List<User> generateTestData() {

        User user1 = new User(1L, "Marcin", "Klasicki", "mar", "pass123", "marcin@klasicki.pl");
        User user2 = new User(2L, "Seba", "Kowalski", "seb", "seba123", "typowy@seba.pl");
        User user3 = new User(3L, "Stefan", "Stefański", "stef", "stef123", "stefan@stefanski.pl");

        return Arrays.asList(user1, user2, user3);
    }
}