package com.rishiharan.freelanceos.dto;

import com.rishiharan.freelanceos.model.ProjectStatus;

public class ProjectRequestDTO {

    private String name;
    private String description;
    private ProjectStatus status;

    // CHANGED: clientId → contactId
    private Long contactId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }
}