package com.rishiharan.freelanceos.controller;

import com.rishiharan.freelanceos.model.Lead;
import com.rishiharan.freelanceos.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leads")
public class LeadController {
    @Autowired
    private LeadService leadService;

    @PostMapping
    public Lead createLead(@RequestBody Lead lead) {
        return leadService.createLead(lead);
    }

    @GetMapping
    public List<Lead> getLeads() {
        return leadService.getAllLeads();
    }
    @GetMapping("/{id}")
    public Lead getLead(@PathVariable long id) {
        return leadService.getLeadById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLead(@PathVariable Integer id) {
        leadService.deleteLeadById(id);
    }
    @PutMapping("/{id}")
    public Lead updateLead(@PathVariable Integer id, @RequestBody Lead lead) {
        return leadService.updateLead(id, lead);
    }


}
