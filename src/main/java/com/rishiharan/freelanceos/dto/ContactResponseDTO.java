package com.rishiharan.freelanceos.dto;

import com.rishiharan.freelanceos.model.ContactType;
import com.rishiharan.freelanceos.model.LeadStatus;

public class ContactResponseDTO {
    private Long id ;
    private String name;
    private String email;
    private String company;
    private ContactType type;
    private LeadStatus status;

    public ContactResponseDTO() {

    }
    public ContactResponseDTO(Long id, String name, String email, String company, ContactType type, LeadStatus status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.company = company;
        this.type = type;
        this.status = status;

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }

    public ContactType getType() {
        return type;
    }

    public LeadStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public void setStatus(LeadStatus status) {
        this.status = status;
    }

}

