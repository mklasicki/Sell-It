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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
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
    void shouldReturnListOfAllUsers() {

        //given
        List<User> users = Arrays.asList(User.builder().id(1L).build(),User.builder().id(2L).build());

        when(userRepository.findAll()).thenReturn(users);

        //when
        List<User> result = userService.getAll();

        //then
        assertThat(result, hasSize(2));
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void shouldThrowDataNotFoundExceptionWhenListOfAllUsersIsEmpty() {

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
    void shouldReturnUserWhenGivenId() {

        //given
        //when
        when(userRepository.findById(USER_ID)).thenReturn(Optional.of(user));
        when(userRepository.existsById(USER_ID)).thenReturn(true);

        User userResult = userService.findById(USER_ID);
        boolean doExists = userRepository.existsById(USER_ID);

        //then
        assertThat(userResult.getName(), is(user.getName()));
        assertTrue(doExists);
        assertNotNull(userResult);
        verify(userRepository, times(1)).findById(USER_ID);
    }

    @Test
    void shouldThrowUserNotFoundExceptionWhenUserNotFoundById() {

        //given
        //when
        when(userRepository.findById(USER_ID)).thenReturn(Optional.empty());
        when(userRepository.existsById(USER_ID)).thenReturn(false);

        boolean doExists = userRepository.existsById(USER_ID);

        //then
        assertFalse(doExists);
        assertThrows(UserNotFoundException.class, () -> userService.findById(USER_ID));
        verify(userRepository, times(1)).findById(any());
    }

    @Test
    void shouldAddNewUser() {

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
    void shouldReturnUserWhenGivenName() {

        //given
        String userName = "Marcin";
        when(userRepository.findAll()).thenReturn(generateTestData());

        //when
        User searchResult = userService.findByName(userName);

        //then
        assertNotNull(searchResult);
        assertThat(searchResult.getName(), is(userName));
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void shouldReturnNullWhenUserIsNotFoundByGivenName() {

        //given
        String userName = "Rafał";
        when(userRepository.findAll()).thenReturn(generateTestData());

        //when
        User searchResult = userService.findByName(userName);

        //then
        assertNull(searchResult);
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void shouldReturnUserWhenGivenLogin() {

        //given
        when(userRepository.findAll()).thenReturn(generateTestData());
        String userLogin = "seb";

        //when
        User searchResult = userService.findUserByLogin(userLogin);

        //then
       assertNotNull(searchResult);
       verify(userRepository, times(1)).findAll();
    }

    @Test
    void shouldReturnNullWhenUserIsNotFoundByGivenLogin() {

        //given
        when(userRepository.findAll()).thenReturn(generateTestData());
        String userLogin = "lol";

        //when
        User searchResult = userService.findUserByLogin(userLogin);

        //then
        assertNull(searchResult);
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void shouldReturnFalseIfEmailIsTaken() {

        //given
        when(userRepository.findAll()).thenReturn(generateTestData());
        String email = "marcin@klasicki.pl";

        //when
        boolean result = userService.isEmailTaken(email);

        //then
        assertFalse(result);
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void shouldReturnTrueIfEmailIsNotTaken() {

        //given
        when(userRepository.findAll()).thenReturn(generateTestData());
        String email = "rafix@klasicki.pl";

        //when
        boolean result = userService.isEmailTaken(email);

        //then
        assertTrue(result);
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void shouldReturnFalseIfLoginIsTaken() {

        //given
        when(userRepository.findAll()).thenReturn(generateTestData());
        String login = "mar";

        //when
        boolean result = userService.isUsernameTaken(login);

        //then
        assertFalse(result);
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void shouldReturnTrueIfLoginIsNotTaken() {

        //given
        when(userRepository.findAll()).thenReturn(generateTestData());
        String login = "lol";

        //when
        boolean result = userService.isUsernameTaken(login);

        //then
        assertTrue(result);
        verify(userRepository, times(1)).findAll();
    }

    private List<User> generateTestData() {

        User user1 = new User(1L, "Marcin", "Klasicki", "mar", "pass123", "marcin@klasicki.pl");
        User user2 = new User(2L, "Seba", "Kowalski", "seb", "seba123", "typowy@seba.pl");
        User user3 = new User(3L, "Stefan", "Stefański", "stef", "stef123", "stefan@stefanski.pl");

        return Arrays.asList(user1, user2, user3);
    }
}