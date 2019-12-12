package com.marcin.config;

import com.marcin.daos.UserRepository;
import com.marcin.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class DbInit implements CommandLineRunner {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public void run(String... args) {
        User marcin = new User("marcin", passwordEncoder.encode("marcin123"));
        User stefan = new User("stefan", passwordEncoder.encode("stefan123"));
        userRepository.save(marcin);
        userRepository.save(stefan);
    }

}
