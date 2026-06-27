package com.rishiharan.freelanceos.dto;

import com.rishiharan.freelanceos.model.Client;
import com.rishiharan.freelanceos.model.Project;
import com.rishiharan.freelanceos.model.ProjectStatus;

public class ProjectRequestDTO {

    private String name;
    private String description;
    private ProjectStatus status;
    private Long clientId;

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
    public ProjectStatus getStatus(){
        return status;
    }
    public void setStatus(ProjectStatus status){
        this.status = this.status;
    }
    public Long getClientId() {
        return clientId;
    }
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }


}
