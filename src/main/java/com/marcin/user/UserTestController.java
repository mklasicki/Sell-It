package com.marcin.user;



import java.net.URI;

import com.marcin.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserTestController {

    private static final Logger logger = LoggerFactory.getLogger(UserTestController.class);
    private final SqlUserRepository userRepository;

    public UserTestController(SqlUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/v1/user")
    ResponseEntity<?> getAll() {
        logger.warn("Exposing all users");
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping("/v1/user")
    ResponseEntity<?> saveUser(@RequestBody User entity){
        userRepository.save(entity);
        return ResponseEntity.created(URI.create("/v1/user" + entity.getId()))
            .build();
    }
}
