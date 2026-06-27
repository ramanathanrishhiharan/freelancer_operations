package com.rishiharan.freelanceos.dto;

import com.rishiharan.freelanceos.model.ProjectStatus;

public class ProjectResponseDTO {

    private Long id;
    private String name;
    private String description;
    private ProjectStatus status;

    // CHANGED FROM CLIENT → CONTACT
    private Long contactId;
    private String contactName;

    public ProjectResponseDTO(Long id,
                              String name,
                              String description,
                              ProjectStatus status,
                              Long contactId,
                              String contactName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.contactId = contactId;
        this.contactName = contactName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public Long getContactId() {
        return contactId;
    }

    public String getContactName() {
        return contactName;
    }
}