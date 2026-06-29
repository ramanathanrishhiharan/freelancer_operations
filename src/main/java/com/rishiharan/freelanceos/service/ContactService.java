package com.rishiharan.freelanceos.service;


import com.rishiharan.freelanceos.dto.ContactRequestDTO;
import com.rishiharan.freelanceos.dto.ContactResponseDTO;
import com.rishiharan.freelanceos.model.Contact;
import com.rishiharan.freelanceos.model.ContactType;
import com.rishiharan.freelanceos.model.LeadStatus;
import com.rishiharan.freelanceos.model.User;
import com.rishiharan.freelanceos.repository.ContactRepository;
import com.rishiharan.freelanceos.repository.UserRepository;
import com.rishiharan.freelanceos.security.UserContext;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final UserContext userContext;

    public ContactService(ContactRepository contactRepository,UserContext userContext) {
        this.contactRepository = contactRepository;
        this.userContext = userContext;
    }





    // CREATE LEAD
    public ContactResponseDTO create(ContactRequestDTO dto) {
        User user = userContext.getCurrentUser();



        Contact contact = new Contact();

        contact.setName(dto.getName());
        contact.setEmail(dto.getEmail());
        contact.setCompany(dto.getCompany());
        contact.setType(dto.getType());

        contact.setStatus(
                dto.getType() == ContactType.LEAD
                        ? LeadStatus.NEW
                        : LeadStatus.CONVERTED
        );

        contact.setCreatedAt(LocalDateTime.now());
        contact.setUser(user);

        return mapToDTO(contactRepository.save(contact));
    }

    public List<ContactResponseDTO> getAllContacts() {
        return contactRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // CONVERT LEAD → CLIENT
    public ContactResponseDTO convertToClient(Long id) {

        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found"));

        contact.setType(ContactType.CLIENT);
        contact.setStatus(LeadStatus.CONVERTED);
        contact.setConvertedAt(LocalDateTime.now());

        Contact saved = contactRepository.save(contact);

        return mapToDTO(saved);
    }

    private ContactResponseDTO mapToDTO(Contact c) {
        return new ContactResponseDTO(
                c.getId(),
                c.getName(),
                c.getEmail(),
                c.getCompany(),
                c.getType(),
                c.getStatus()
        );
    }
}