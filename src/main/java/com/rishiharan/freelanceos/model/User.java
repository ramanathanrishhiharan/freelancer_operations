package com.rishiharan.freelanceos.model;


import jakarta.persistence.*;

@Entity
@Table(name="users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    public User(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;

    }

    public User() {

    }


    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public long getId(){
        return id;
    }

    public void setName(String name){
        this.name = name ;
    }
    public void setEmail(String email){
        this.email= email;
    }

}
