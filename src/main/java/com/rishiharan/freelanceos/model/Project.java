package com.rishiharan.freelanceos.model;

import jakarta.persistence.*;

@Entity
@Table(name="projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
     private String description;
     @Enumerated(EnumType.STRING)
    private ProjectStatus status;
     @ManyToOne
     @JoinColumn(name = "client_id")
    private Client client;

     public Project(){

     }
     public Project(Long id, String name, String description, ProjectStatus status,Client client){
         this.id = id;
         this.name = name;
         this.description = description;
         this.status = status;
         this.client = client;
     }

     public Long getId() {
         return id;
     }
     public void setId(Long id) {
         this.id = id;
     }
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
         this.status = status;
     }

     public Client getClient() {
         return client;
     }
     public void setClient(Client client) {
         this.client = client;
     }
}
