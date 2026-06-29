package com.rishiharan.freelanceos.service;

import com.rishiharan.freelanceos.dto.LoginRequestDTO;
import com.rishiharan.freelanceos.dto.LoginResponseDTO;
import com.rishiharan.freelanceos.model.User;
import com.rishiharan.freelanceos.repository.UserRepository;
import com.rishiharan.freelanceos.security.JwtService;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }
    public LoginResponseDTO login(LoginRequestDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!user.getPassword().equals(dto.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        String token = jwtService.generateToken(user.getEmail());
        return new LoginResponseDTO(
                token,
                user.getId(),
                user.getName(),
                user.getEmail()
        );



    }

}
