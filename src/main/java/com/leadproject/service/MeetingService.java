package com.leadproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadproject.model.Meeting;
import com.leadproject.repository.MeetingRepository;

@Service
public class MeetingService
{
    @Autowired
    private MeetingRepository meetingRepository;

    public Meeting create(Meeting meeting)
    {
        return meetingRepository.save(meeting);
    }

    public Meeting getByLeadIdAndId(Long lead_id, Long id)
    {
    	Optional<Meeting> meetings = meetingRepository.findByIdAndLeadId(id, lead_id);
        if (meetings.isPresent())
        {
            return meetings.get();
        }
        else
        {
            return null;
        }
    }
    
    public List<Meeting> findByLeadId(Long lead_id)
    {
    	return meetingRepository.findByLeadId(lead_id);
    }
    
    public Meeting get(Long id)
    {
        Optional<Meeting> followup = meetingRepository.findById(id);
        if (followup.isPresent())
        {
            return followup.get();
        }
        else
        {
            return null;
        }

    }

}
