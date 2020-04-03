package com.leadproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leadproject.model.Lead;
import com.leadproject.service.LeadService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rest")
public class LeadController 
{
    @Autowired
    private LeadService leadService;

    @PostMapping("/leads")
    public Lead create(@RequestBody Lead lead)
    {
        Lead p = leadService.create(lead);
        return p;
    }

    @GetMapping("/leads/{id}")
    public Lead getLead(@PathVariable Long id)
    {
        return leadService.get(id);
    }

    @GetMapping("/leads")
    public List<Lead> getLeads()
    {
        return leadService.getAll();
    }

    @PutMapping("/leads/{id}")
    public Lead update(@RequestBody Lead lead, @PathVariable Long id)
    {
        Lead leadUpdated = leadService.update(lead, id);
        return leadUpdated;
    }

    @DeleteMapping("/leads/{id}")
    public void deleteLead(@PathVariable Long id)
    {
        leadService.delete(id);
    }

    @DeleteMapping("/leads")
    public void deleteLeads()
    {
        leadService.deleteAll();
    }
}
