package com.rishiharan.freelanceos.dto;

import com.rishiharan.freelanceos.model.Client;
import com.rishiharan.freelanceos.model.ProjectStatus;

public class ProjectResponseDTO {
    private Long id;
    private String name;
    private String description;
    private ProjectStatus status;
    private Long clientId;
    private String clientName;

    public ProjectResponseDTO(Long id, String name, String description, ProjectStatus status, Long clientId, String clientName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.clientId = clientId;
        this.clientName = clientName;
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
    public Long getClientId() {
        return clientId;
    }
    public String getClient() {
        return clientName;
    }
}
