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
    private String password;

    public User(long id, String name, String email,String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;

    }

    public User() {

    }


    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public Long getId(){
        return id;
    }
    public String getPassword() {
        return password;
    }

    public void setName(String name){
        this.name = name ;
    }
    public void setEmail(String email){
        this.email= email;
    }
    public void setId(Long id){
        this.id = id;

    }

    public void setPassword(String password) {
        this.password = password;
    }

}
