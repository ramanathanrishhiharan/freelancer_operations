package com.rishiharan.freelanceos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String company;

    public Client( long id,String name, String email, String company) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.company = company;
    }
    public Client() {

    }
    public Long getId(){
        return id;
    }
    public String getName(){
        return name;

    }
    public String getEmail(){
        return email;

    }
    public String getCompany(){
        return company;
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
}
