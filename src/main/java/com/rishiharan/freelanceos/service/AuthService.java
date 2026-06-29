package com.rishiharan.freelanceos.service;

import com.rishiharan.freelanceos.dto.LoginRequestDTO;
import com.rishiharan.freelanceos.dto.LoginResponseDTO;
import com.rishiharan.freelanceos.dto.RegisterRequestDTO;
import com.rishiharan.freelanceos.dto.RegisterResponseDTO;
import com.rishiharan.freelanceos.model.User;
import com.rishiharan.freelanceos.repository.UserRepository;
import com.rishiharan.freelanceos.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       JwtService jwtService,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }
    public LoginResponseDTO login(LoginRequestDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
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
    public RegisterResponseDTO register(RegisterRequestDTO dto) {

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());


        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        User saved = userRepository.save(user);

        return new RegisterResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getEmail()
        );
    }

}
