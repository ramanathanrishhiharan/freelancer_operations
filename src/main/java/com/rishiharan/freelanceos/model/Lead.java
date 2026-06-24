package com.rishiharan.freelanceos.model;

public class Lead {
    private long id;
    private String name;
    private String email;
    private String company;


    public Lead(String name, String email, String company) {
        this.name =name;
        this.email = email;
        this.company= company;


    }
    public Lead() {}

    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getCompany(){
        return company;
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
    public void setCompany(String company){
        this.company= company;
    }
    public void setId(long id){
        this.id = id;

    }

}
