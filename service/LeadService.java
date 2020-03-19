package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Lead;
import com.example.demo.repository.LeadRepository;

@Service
public class LeadService
{
    @Autowired
    private LeadRepository leadRepository;

    public Lead create(Lead lead)
    {
        return leadRepository.save(lead);
    }

    public List<Lead> getAll()
    {
        return leadRepository.findAll();
    }

    public List<Lead> getFilteredLeads(String from, String to)
    {
        LocalDate a = LocalDate.parse(from);
        LocalDate b = LocalDate.parse(to);
        return leadRepository.getLeadsByDate(a, b);
    }

    public Lead get(String id)
    {
        Optional<Lead> lead = leadRepository.findById(id);
        if (lead.isPresent())
        {
            return lead.get();
        }
        else
        {
            return null;
        }

    }

    public Lead update(final Lead lead)
    {
        String uniqueEmail = lead.getEmailAddress();
        if (null != uniqueEmail)
        {
            return leadRepository.save(lead);
        }
        return lead;
    }

    public void deleteAll()
    {
        leadRepository.deleteAll();
    }

    public void delete(String id)
    {
        Optional<Lead> lead = leadRepository.findById(id);
        if (lead.isPresent())
        {
            leadRepository.delete(lead.get());
        }
    }
}
