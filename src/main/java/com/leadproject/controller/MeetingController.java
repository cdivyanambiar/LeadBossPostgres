package com.leadproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leadproject.model.Meeting;
import com.leadproject.repository.LeadRepository;
import com.leadproject.repository.MeetingRepository;
import com.leadproject.service.MeetingService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/rest")
public class MeetingController 
{
	@Autowired
	private LeadRepository leadRepository;
	
	@Autowired
	private MeetingRepository meetingRepository;
	
	@Autowired
	private MeetingService meetingService;

	@GetMapping("/lead/{lead_id}/meetings")
    public List<Meeting> getAllFollowupsByLeadId(@PathVariable (value = "lead_id") Long lead_id) 
	{
        return meetingService.findByLeadId(lead_id);
    }
	
	@PostMapping("/lead/{lead_id}/meeting")
	public Meeting create(@PathVariable (value = "lead_id") Long lead_id,
            @Valid @RequestBody Meeting meeting) throws Exception 
	{
			return leadRepository.findById(lead_id).map(lead -> {
			meeting.setLead(lead);
			return meetingService.create(meeting);
			}).orElseThrow(() -> new Exception("Lead Id " + lead_id + " not found"));
	}
	
	@GetMapping("/lead/{lead_id}/metting/{id}")
    public Meeting getFollowupByLeadIdandId(@PathVariable (value = "lead_id") Long lead_id, @PathVariable (value = "id") Long id) 
	{
        return meetingService.getByLeadIdAndId(lead_id,id);
    }
	
	@PutMapping("/lead/{lead_id}/meeting/{id}")	
    public Meeting update(@PathVariable (value = "lead_id") Long lead_id,
                                 @PathVariable (value = "id") Long id,@Valid @RequestBody Meeting meetingRequest) throws Exception {
        if(!leadRepository.existsById(lead_id)) {
            throw new Exception("PostId " + lead_id + " not found");
        }

        return meetingRepository.findById(id).map(meeting -> {
        	meeting.setDescription(meetingRequest.getDescription());
        	meeting.setOrganizer(meetingRequest.getOrganizer());
        	meeting.setStarttime(meetingRequest.getStarttime());
        	meeting.setEndTime(meetingRequest.getEndTime());
        	meeting.setOwner(meetingRequest.getOwner());
        	meeting.setRemainer_period(meetingRequest.getRemainer_period());
        	meeting.setRecuring(meetingRequest.isRecuring());
        	meeting.setRecuring_period(meetingRequest.getRecuring_period());
        	meeting.setRemainder(meetingRequest.isRemainder());
        	meeting.setSubject(meetingRequest.getSubject());
        	return meetingRepository.save(meeting);
        }).orElseThrow(() -> new Exception("Meeting Id " + id + " not found"));
    }

    @DeleteMapping("/lead/{lead_id}/meeting/{id}")	
    public ResponseEntity<?> delete(@PathVariable (value = "lead_id") Long lead_id,
                              @PathVariable (value = "id") Long id) throws Exception {
        return meetingRepository.findByIdAndLeadId(id, lead_id).map(meeting -> {
        	meetingRepository.delete(meeting);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new Exception("Meeting not found with id " + id + " and Leadid " + lead_id));
    }

}
