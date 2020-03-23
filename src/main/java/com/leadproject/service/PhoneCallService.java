package com.leadproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadproject.model.PhoneCall;
import com.leadproject.repository.PhoneCallRepository;

@Service
public class PhoneCallService
{

    @Autowired
    private PhoneCallRepository phoneCallRepository;

    public PhoneCall create(PhoneCall phoneCall)
    {
        return phoneCallRepository.save(phoneCall);
    }

    public PhoneCall getByLeadIdAndId(Long lead_id, Long id)
    {
    	Optional<PhoneCall> phoneCall = phoneCallRepository.findByIdAndLeadId(id, lead_id);
        if (phoneCall.isPresent())
        {
            return phoneCall.get();
        }
        else
        {
            return null;
        }
    }
    
    public List<PhoneCall> findByLeadId(Long lead_id)
    {
    	return phoneCallRepository.findByLeadId(lead_id);
    }
    
    public PhoneCall get(Long id)
    {
        Optional<PhoneCall> phoneCall = phoneCallRepository.findById(id);
        if (phoneCall.isPresent())
        {
            return phoneCall.get();
        }
        else
        {
            return null;
        }

    }
}
