package com.marcin.service.impl;

import com.marcin.repositories.UserRepository;
import com.marcin.domain.User;
import com.marcin.dto.UserDTO;
import com.marcin.exceptions.DuplicatedDataException;
import com.marcin.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        if (userRepository.findOneByNameAndLastName(user.getName(), user.getLastName()).isPresent()) {
            throw new DuplicatedDataException("User with name " + user.getName()
                                                +  " and last name " + user.getLastName() + "already exists");
        }
        userRepository.save(user);
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findAll().stream()
            .filter(user -> user.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public User findUserByLogin(String login) {
        return userRepository.findAll().stream()
            .filter(user -> user.getLogin().equals(login)).findFirst().orElse(null);
    }

    @Override
    public void updateUser(Long id, UserDTO userDTO) {
        if (userDTO != null) {

            User userToUpdate = userRepository.findById(id).get();

            if (valueCheck(userDTO.getUsername())) {
                userToUpdate.setName(userDTO.getUsername());
            }
            if (valueCheck(userDTO.getLastName())) {
                userToUpdate.setLastName(userDTO.getLastName());
            }
            if (valueCheck(userDTO.getPassword())) {
                userToUpdate.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            }
            if (valueCheck(userDTO.getEmail())) {
                userToUpdate.setEmail(userDTO.getEmail());
            }

            userRepository.save(userToUpdate);
        } else {
            throw new NullPointerException("User not found");
        }
    }

    private boolean valueCheck(String value) {
        return !value.trim().isEmpty();
    }
}