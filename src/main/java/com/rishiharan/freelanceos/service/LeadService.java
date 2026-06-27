package com.rishiharan.freelanceos.service;

import com.rishiharan.freelanceos.dto.ClientResponseDTO;
import com.rishiharan.freelanceos.dto.LeadRequestDTO;
import com.rishiharan.freelanceos.dto.LeadResponseDTO;
import com.rishiharan.freelanceos.exception.LeadNotFoundException;
import com.rishiharan.freelanceos.model.Lead;
import com.rishiharan.freelanceos.repository.LeadRepository;
import org.springframework.stereotype.Service;
import com.rishiharan.freelanceos.repository.ClientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeadService {

    private final LeadRepository leadRepository;


    public LeadService(LeadRepository leadRepository, ClientRepository clientRepository) {
        this.leadRepository = leadRepository;

    }

    // CREATE
    public LeadResponseDTO createLead(LeadRequestDTO dto) {

        Lead lead = new Lead();
        lead.setName(dto.getName());
        lead.setEmail(dto.getEmail());
        lead.setCompany(dto.getCompany());

        Lead savedLead = leadRepository.save(lead);

        return mapToResponseDTO(savedLead);
    }

    // GET ALL
    public List<LeadResponseDTO> getAllLeads() {
        return leadRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public LeadResponseDTO getLeadById(long id) {

        Lead lead = leadRepository.findById(id)
                .orElse(null);

        if (lead == null) {
            throw new LeadNotFoundException("Lead not found with id: " + id);
        }

        return mapToResponseDTO(lead);
    }

    // DELETE
    public void deleteLeadById(long id) {
        leadRepository.deleteById(id);
    }

    // UPDATE
    public LeadResponseDTO updateLead(long id, LeadRequestDTO dto) {

        Lead existingLead = leadRepository.findById(id)
                .orElse(null);

        if (existingLead == null) {
            throw new LeadNotFoundException("Lead not found with id: " + id);
        }

        existingLead.setName(dto.getName());
        existingLead.setEmail(dto.getEmail());
        existingLead.setCompany(dto.getCompany());

        Lead updatedLead = leadRepository.save(existingLead);

        return mapToResponseDTO(updatedLead);
    }

    //converting the lead to client



    // MAPPER
    private LeadResponseDTO mapToResponseDTO(Lead lead) {

        return new LeadResponseDTO(
                lead.getId(),
                lead.getName(),
                lead.getEmail(),
                lead.getCompany()
        );
    }
}