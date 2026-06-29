package com.rishiharan.freelanceos.controller;

import com.rishiharan.freelanceos.dto.LoginRequestDTO;
import com.rishiharan.freelanceos.dto.LoginResponseDTO;
import com.rishiharan.freelanceos.dto.RegisterRequestDTO;
import com.rishiharan.freelanceos.dto.RegisterResponseDTO;
import com.rishiharan.freelanceos.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@Valid @RequestBody LoginRequestDTO dto) {
        return authService.login(dto);
    }


    @PostMapping("/register")
    public RegisterResponseDTO register(@Valid @RequestBody RegisterRequestDTO dto) {
        return authService.register(dto);
    }
}
