package com.rishiharan.freelanceos.dto;

public class ClientResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String company;
    public ClientResponseDTO(Long id, String name, String email, String company) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.company = company;
    }
    public Long getId() {
        return id;
    }

    public String getName(){
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getCompany() {
        return company;
    }
}
