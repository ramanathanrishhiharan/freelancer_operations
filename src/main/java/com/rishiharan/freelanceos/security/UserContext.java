package com.rishiharan.freelanceos.security;

import com.rishiharan.freelanceos.model.User;
import com.rishiharan.freelanceos.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserContext {

    private final UserRepository userRepository;

    public UserContext(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // TEMP: mock logged-in user
    public User getCurrentUser() {
        return userRepository.findById(2L)
                .orElseThrow(() -> new RuntimeException("Default user not found"));
    }
}