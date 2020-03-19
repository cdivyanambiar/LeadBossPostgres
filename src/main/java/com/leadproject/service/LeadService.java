package com.leadproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadproject.model.Lead;
import com.leadproject.repository.LeadRepository;

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

    //    public List<Lead> getFilteredLeads(String from, String to)
    //    {
    //        LocalDate a = LocalDate.parse(from);
    //        LocalDate b = LocalDate.parse(to);
    //        return leadRepository.getLeadsByDate(a, b);
    //    }

    public Lead get(Long id)
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

    public Lead update(final Lead lead, final Long id)
    {
        Optional<Lead> leadOptional = leadRepository.findById(id);
        if (null != leadOptional.get())
        {
            Lead leadEntity = leadOptional.get();
            leadEntity.setLeadSource(lead.getLeadSource());
            leadEntity.setLeadType(lead.getLeadType());
            leadEntity.setDateOfAddition(lead.getDateOfAddition());
            leadEntity.setOccupancyStatus(lead.getOccupancyStatus());
            leadEntity.setLeadInterest(lead.getLeadInterest());
            leadEntity.setClinicalIntensity(lead.getClinicalIntensity());
            leadEntity.setFirstName(lead.getFirstName());
            leadEntity.setLastName(lead.getLastName());
            leadEntity.setGender(lead.getGender());
            leadEntity.setEmailAddress(lead.getEmailAddress());
            leadEntity.setPhoneNumber(lead.getPhoneNumber());
            leadEntity.setAdditionalNotes(lead.getAdditionalNotes());
            leadEntity.setAdditionalLeadDetails(lead.getAdditionalLeadDetails());
            leadEntity.setFollowup(lead.getFollowup());
            return leadRepository.save(leadEntity);
        }
        return lead;
    }

    public void deleteAll()
    {
        leadRepository.deleteAll();
    }

    public void delete(Long id)
    {
        Optional<Lead> lead = leadRepository.findById(id);
        if (lead.isPresent())
        {
            leadRepository.delete(lead.get());
        }
    }
}
