package com.rishiharan.freelanceos.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String company;

    @Enumerated(EnumType.STRING)
    private ContactType type;

    @Enumerated(EnumType.STRING)
    private LeadStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime convertedAt;

    public Contact() {
    }

    public Contact(Long id, String name, String email, String company,
                   ContactType type, LeadStatus status,
                   LocalDateTime createdAt, LocalDateTime convertedAt) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.company = company;
        this.type = type;
        this.status = status;
        this.createdAt = createdAt;
        this.convertedAt = convertedAt;
    }

    // GETTERS

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getConvertedAt() {
        return convertedAt;
    }

    // SETTERS

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

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setConvertedAt(LocalDateTime convertedAt) {
        this.convertedAt = convertedAt;
    }
}