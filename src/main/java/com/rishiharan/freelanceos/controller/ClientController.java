package com.rishiharan.freelanceos.controller;


import com.rishiharan.freelanceos.dto.ClientRequestDTO;
import com.rishiharan.freelanceos.dto.ClientResponseDTO;
import com.rishiharan.freelanceos.dto.UserRequestDTO;
import com.rishiharan.freelanceos.dto.UserResponseDTO;
import com.rishiharan.freelanceos.model.Client;
import com.rishiharan.freelanceos.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    public ClientResponseDTO createClient(@Valid @RequestBody ClientRequestDTO dto) {
        return clientService.createClient(dto);
    }
    @GetMapping
    public List<ClientResponseDTO> getClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ClientResponseDTO getClient(@PathVariable long id) {
        return clientService.getClientById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable long id) {
        clientService.deleteClientById(id);
        return "Client deleted successfully";
    }

    // UPDATE
    @PutMapping("/{id}")
    public ClientResponseDTO updateClient(
            @PathVariable long id,
            @Valid @RequestBody ClientRequestDTO dto) {

        return clientService.updateClient(id, dto);
    }

    @PostMapping("/convert/{leadId}")
    public ClientResponseDTO convertClient(@PathVariable long leadId) {
        return clientService.convertLeadToClient(leadId);
    }
}
