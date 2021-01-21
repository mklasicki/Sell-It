package com.marcin.service.impl;

import com.marcin.daos.UserRepository;
import com.marcin.domain.User;
import com.marcin.dto.UserDTO;
import com.marcin.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void saveUser(User user) {
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