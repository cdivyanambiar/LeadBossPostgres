package com.leadproject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.leadproject.model.PhoneCall;
import com.leadproject.repository.LeadRepository;
import com.leadproject.repository.PhoneCallRepository;
import com.leadproject.service.PhoneCallService;
@RestController
public class PhoneCallController 
{
	@Autowired
	private LeadRepository leadRepository;
	
	@Autowired
	private PhoneCallRepository phoneCallRepository;
	
	@Autowired
	private PhoneCallService phoneCallService;

	@GetMapping("/lead/{lead_id}/phonecalls")
    public List<PhoneCall> getAllFollowupsByLeadId(@PathVariable (value = "lead_id") Long lead_id) 
	{
        return phoneCallService.findByLeadId(lead_id);
    }
	
	@PostMapping("/lead/{lead_id}/phonecall")
	public PhoneCall create(@PathVariable (value = "lead_id") Long lead_id,
            @Valid @RequestBody PhoneCall phoneCall) throws Exception 
	{
			return leadRepository.findById(lead_id).map(lead -> {
				phoneCall.setLead(lead);
			return phoneCallService.create(phoneCall);
			}).orElseThrow(() -> new Exception("Lead Id " + lead_id + " not found"));
	}
	
	@GetMapping("/lead/{lead_id}/phonecall/{id}")
    public PhoneCall getFollowupByLeadIdandId(@PathVariable (value = "lead_id") Long lead_id, @PathVariable (value = "id") Long id) 
	{
        return phoneCallService.getByLeadIdAndId(lead_id,id);
    }
	
	@PutMapping("/lead/{lead_id}/phonecall/{id}")	
    public PhoneCall update(@PathVariable (value = "lead_id") Long lead_id,
                                 @PathVariable (value = "id") Long id,@Valid @RequestBody PhoneCall phoneCallRequest) throws Exception {
        if(!leadRepository.existsById(lead_id)) {
            throw new Exception("Lead Id " + lead_id + " not found");
        }

        return phoneCallRepository.findById(id).map(phonecall -> {
        	phonecall.setDescription(phoneCallRequest.getDescription());
        	phonecall.setOrganizer(phoneCallRequest.getOrganizer());
        	phonecall.setStarttime(phoneCallRequest.getStarttime());
        	phonecall.setEndTime(phoneCallRequest.getEndTime());
        	phonecall.setOwner(phoneCallRequest.getOwner());
        	phonecall.setRemainer_period(phoneCallRequest.getRemainer_period());
        	phonecall.setRecuring(phoneCallRequest.isRecuring());
        	phonecall.setRecuring_period(phoneCallRequest.getRecuring_period());
        	phonecall.setRemainder(phoneCallRequest.isRemainder());
        	phonecall.setSubject(phoneCallRequest.getSubject());
        	return phoneCallRepository.save(phonecall);
        }).orElseThrow(() -> new Exception("Phone call Id " + id + " not found"));
    }

    @DeleteMapping("/lead/{lead_id}/phonecall/{id}")	
    public ResponseEntity<?> delete(@PathVariable (value = "lead_id") Long lead_id,
                              @PathVariable (value = "id") Long id) throws Exception {
        return phoneCallRepository.findByIdAndLeadId(id, lead_id).map(meeting -> {
        	phoneCallRepository.delete(meeting);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new Exception("Phone call not found with id " + id + " and Leadid " + lead_id));
    }

}
