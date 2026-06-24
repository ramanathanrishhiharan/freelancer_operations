package com.rishiharan.freelanceos.service;

import com.rishiharan.freelanceos.model.Lead;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.ArrayList;

@Service
public class LeadService {

    private List<Lead> leads = new ArrayList<>();
    private long  idCounter=1;

    public Lead createLead(Lead lead){


        lead.setId(idCounter++);
        leads.add(lead);
        return lead;

    }
    public List<Lead> getAllLeads(){
        return leads;
    }
    public Lead getLeadById(long id){
        for(Lead lead:leads){
            if(lead.getId()==id){
                return lead;
            }
        }
        return null;
    }
    public void deleteLeadById(long id){
        leads.removeIf(lead -> lead.getId() == id);
    }
    public Lead updateLead(long id, Lead updatedLead){
        Lead existingLead= getLeadById(id);
        if (existingLead == null) {
            return null;
        }
        existingLead.setName(updatedLead.getName());
        existingLead.setEmail(updatedLead.getEmail());
        existingLead.setCompany(updatedLead.getCompany());

        return existingLead;

    }
}
