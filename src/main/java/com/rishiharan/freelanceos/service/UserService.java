package com.rishiharan.freelanceos.service;


import com.rishiharan.freelanceos.dto.LeadRequestDTO;
import com.rishiharan.freelanceos.dto.LeadResponseDTO;
import com.rishiharan.freelanceos.dto.UserRequestDTO;
import com.rishiharan.freelanceos.dto.UserResponseDTO;
import com.rishiharan.freelanceos.exception.LeadNotFoundException;
import com.rishiharan.freelanceos.exception.UserNotFoundException;
import com.rishiharan.freelanceos.model.Lead;
import com.rishiharan.freelanceos.model.User;
import com.rishiharan.freelanceos.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    //create user
    //get all user
    //get user by id
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        User savedUser = userRepository.save(user);

        return mapToResponseDTO(savedUser);

    }
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }
    public UserResponseDTO getUserById(long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
    public UserResponseDTO updateUser(long id, UserRequestDTO dto) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        existingUser.setName(dto.getName());
        existingUser.setEmail(dto.getEmail());

        User updatedUser = userRepository.save(existingUser);

        return mapToResponseDTO(updatedUser);
    }

    private UserResponseDTO mapToResponseDTO(User user) {

        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail()

        );
    }

}
