package com.rishiharan.freelanceos.service;

import com.rishiharan.freelanceos.dto.ClientRequestDTO;
import com.rishiharan.freelanceos.dto.ClientResponseDTO;
import com.rishiharan.freelanceos.dto.UserRequestDTO;
import com.rishiharan.freelanceos.dto.UserResponseDTO;
import com.rishiharan.freelanceos.exception.ClientNotFoundException;
import com.rishiharan.freelanceos.exception.LeadNotFoundException;
import com.rishiharan.freelanceos.exception.UserNotFoundException;
import com.rishiharan.freelanceos.model.Client;
import com.rishiharan.freelanceos.model.Lead;
import com.rishiharan.freelanceos.model.User;
import com.rishiharan.freelanceos.repository.ClientRepository;
import com.rishiharan.freelanceos.repository.LeadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final LeadRepository leadRepository;

    public ClientService(ClientRepository clientRepository, LeadRepository leadRepository) {

        this.clientRepository = clientRepository;
        this.leadRepository= leadRepository;
    }

    public ClientResponseDTO createClient(ClientRequestDTO dto) {
        Client client = new Client();
        client.setName(dto.getName());
        client.setEmail(dto.getEmail());
        client.setCompany(dto.getCompany());

        Client savedClient = clientRepository.save(client);
        return mapToResponseDTO(savedClient);

    }

    public List<ClientResponseDTO> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }
    public ClientResponseDTO getClientById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException("client not found with id: " + id));
        return new ClientResponseDTO(
                client.getId(),
                client.getName(),
                client.getEmail(),
                client.getCompany()
        );
    }
    public void  deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }

    public ClientResponseDTO updateClient(long id, ClientRequestDTO dto) {

        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client not found with id: " + id));

        existingClient.setName(dto.getName());
        existingClient.setEmail(dto.getEmail());
        existingClient.setCompany(dto.getCompany());

        Client updatedClient = clientRepository.save(existingClient);

        return mapToResponseDTO(updatedClient);
    }
    public ClientResponseDTO convertLeadToClient(long leadId) {
        Lead lead = leadRepository.findById(leadId).orElseThrow(()->new LeadNotFoundException("Lead not found with this id "+leadId));

        Client client = new  Client();

        client.setName(lead.getName());
        client.setEmail(lead.getEmail());
        client.setCompany(lead.getCompany());

        Client savedClient = clientRepository.save(client);

        leadRepository.deleteById(leadId);
         return  mapToResponseDTO(savedClient);

    }
    private ClientResponseDTO mapToResponseDTO(Client client) {

        return new ClientResponseDTO(
                client.getId(),
                client.getName(),
                client.getEmail(),
                client.getCompany()

        );
    }


}

