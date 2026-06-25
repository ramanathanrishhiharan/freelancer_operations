package com.rishiharan.freelanceos.dto;

import jakarta.validation.constraints.NotBlank;

public class UserRequestDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String email;

    public  UserRequestDTO() {

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


}
