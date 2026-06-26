package com.rishiharan.freelanceos.dto;

import jakarta.validation.constraints.NotBlank;

public class ClientRequestDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String company;

    public ClientRequestDTO(){

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
}
