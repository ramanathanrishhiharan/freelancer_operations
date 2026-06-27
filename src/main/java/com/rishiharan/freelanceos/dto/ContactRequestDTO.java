package com.rishiharan.freelanceos.dto;

import com.rishiharan.freelanceos.model.ContactType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ContactRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Company is required")
    private String company;

    // ADD THIS
    @NotBlank(message = "Type is required")
    private ContactType type;

    public ContactRequestDTO() {}

    public ContactRequestDTO(String name, String email, String company, ContactType type) {
        this.name = name;
        this.email = email;
        this.company = company;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    // FIXED
    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }
}