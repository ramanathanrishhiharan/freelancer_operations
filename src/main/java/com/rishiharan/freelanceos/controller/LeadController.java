package com.rishiharan.freelanceos.controller;

import com.rishiharan.freelanceos.dto.LeadRequestDTO;
import com.rishiharan.freelanceos.dto.LeadResponseDTO;
import com.rishiharan.freelanceos.model.Lead;
import com.rishiharan.freelanceos.service.LeadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leads")
public class LeadController {

    @Autowired
    private LeadService leadService;

    // CREATE
    @PostMapping
    public LeadResponseDTO createLead(@Valid @RequestBody LeadRequestDTO dto) {
        return leadService.createLead(dto);
    }

    // GET ALL
    @GetMapping
    public List<LeadResponseDTO> getLeads() {
        return leadService.getAllLeads();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public LeadResponseDTO getLead(@PathVariable long id) {
        return leadService.getLeadById(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteLead(@PathVariable long id) {
        leadService.deleteLeadById(id);
        return "Lead deleted successfully";
    }

    // UPDATE
    @PutMapping("/{id}")
    public LeadResponseDTO updateLead(
            @PathVariable long id,
            @Valid @RequestBody LeadRequestDTO dto) {

        return leadService.updateLead(id, dto);
    }
}