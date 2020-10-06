package com.marcin.service.impl;

import com.marcin.daos.UserRepository;
import com.marcin.domain.User;
import com.marcin.dto.UserDTO;
import com.marcin.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
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
                .filter(user->user.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public void updateUser(Long id, UserDTO userDTO) {
        User userToUpdate = userRepository.findById(id).orElse(null);
        userToUpdate.setName(userDTO.getUsername());
        userToUpdate.setLastName(userDTO.getUsername());
        userToUpdate.setPassword(userDTO.getPassword());
        userToUpdate.setEmail(userDTO.getEmail());
        userRepository.save(userToUpdate);

    }


}