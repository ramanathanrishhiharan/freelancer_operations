package com.rishiharan.freelanceos.controller;

import com.rishiharan.freelanceos.dto.ContactRequestDTO;
import com.rishiharan.freelanceos.dto.ContactResponseDTO;
import com.rishiharan.freelanceos.model.Lead;
import com.rishiharan.freelanceos.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    private final ContactService contactService;

    public ContactController (ContactService contactService) {
        this.contactService = contactService;
    }
    @GetMapping
    public List<ContactResponseDTO> getAllContacts() {
        return contactService.getAllContacts();
    }
    @PostMapping
   public ContactResponseDTO create(@RequestBody ContactRequestDTO dto){
        return contactService.create(dto);
    }
    @PostMapping("/convert/{id}")
    public ContactResponseDTO convert(@PathVariable Long id) {
        return contactService.convertToClient(id);
    }

}
