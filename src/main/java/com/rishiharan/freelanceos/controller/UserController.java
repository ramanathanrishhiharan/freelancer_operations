package com.rishiharan.freelanceos.controller;


import com.rishiharan.freelanceos.dto.LeadRequestDTO;
import com.rishiharan.freelanceos.dto.LeadResponseDTO;
import com.rishiharan.freelanceos.dto.UserRequestDTO;
import com.rishiharan.freelanceos.dto.UserResponseDTO;
import com.rishiharan.freelanceos.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponseDTO createUser(@Valid @RequestBody UserRequestDTO dto) {
        return userService.createUser(dto);
    }

    // GET ALL
    @GetMapping
    public List<UserResponseDTO> getUsers() {
        return userService.getAllUsers();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public UserResponseDTO getUser(@PathVariable long id) {
        return userService.getUserById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.deleteUserById(id);
        return "User deleted successfully";
    }

    // UPDATE
    @PutMapping("/{id}")
    public UserResponseDTO updateUser(
            @PathVariable long id,
            @Valid @RequestBody UserRequestDTO dto) {

        return userService.updateUser(id, dto);
    }

}
