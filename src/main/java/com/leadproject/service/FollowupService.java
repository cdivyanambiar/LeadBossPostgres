package com.leadproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadproject.model.Followup;
import com.leadproject.model.Lead;
import com.leadproject.repository.FollowupRepository;

@Service
public class FollowupService
{
    @Autowired
    private FollowupRepository followupRepository;

    public Followup create(Followup followup)
    {
        return followupRepository.save(followup);
    }

    public Followup getByLeadIdAndId(Long lead_id, Long id)
    {
    	Optional<Followup> followup = followupRepository.findByIdAndLeadId(id, lead_id);
        if (followup.isPresent())
        {
            return followup.get();
        }
        else
        {
            return null;
        }
    }
    
    public List<Followup> findByLeadId(Long lead_id)
    {
    	return followupRepository.findByLeadId(lead_id);
    }
    
    public Followup get(Long id)
    {
        Optional<Followup> followup = followupRepository.findById(id);
        if (followup.isPresent())
        {
            return followup.get();
        }
        else
        {
            return null;
        }

    }

//    public Followup update(final Followup followup, final Long id)
//    {
//        Optional<Followup> followupOptional = followupRepository.findById(id);
//        if (null != followupOptional.get())
//        {
//        	Followup followupEntity = followupOptional.get();
//        	followupEntity.setLead(followup.getLead());
//        	followupEntity.setLeadType(lead.getLeadType());
//        	followupEntity.setDateOfAddition(lead.getDateOfAddition());
//            followupEntity.setOccupancyStatus(lead.getOccupancyStatus());
//            followupEntity.setLeadInterest(lead.getLeadInterest());
//            followupEntity.setClinicalIntensity(lead.getClinicalIntensity());
//            followupEntity.setFirstName(lead.getFirstName());
//            followupEntity.setLastName(lead.getLastName());
//            followupEntity.setGender(lead.getGender());
//            followupEntity.setEmailAddress(lead.getEmailAddress());
//            followupEntity.setPhoneNumber(lead.getPhoneNumber());
//           
//            return followupRepository.save(followupEntity);
//        }
//        return lead;
//    }
//
//    public void deleteAll()
//    {
//        leadRepository.deleteAll();
//    }
//
//    public void delete(Long id)
//    {
//        Optional<Lead> lead = leadRepository.findById(id);
//        if (lead.isPresent())
//        {
//            leadRepository.delete(lead.get());
//        }
//    }
}
