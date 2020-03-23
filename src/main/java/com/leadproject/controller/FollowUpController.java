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

import com.leadproject.model.Followup;
import com.leadproject.repository.FollowupRepository;
import com.leadproject.repository.LeadRepository;
import com.leadproject.service.FollowupService;
@RestController
public class FollowUpController 
{
	@Autowired
	private LeadRepository leadRepository;
	
	@Autowired
	private FollowupRepository followupRepository;
	
	@Autowired
	private FollowupService followupService;

	@GetMapping("/lead/{lead_id}/followups")
    public List<Followup> getAllFollowupsByLeadId(@PathVariable (value = "lead_id") Long lead_id) 
	{
        return followupService.findByLeadId(lead_id);
    }
	
	@PostMapping("/lead/{lead_id}/followup")
	public Followup create(@PathVariable (value = "lead_id") Long lead_id,
            @Valid @RequestBody Followup followup) throws Exception 
	{
			return leadRepository.findById(lead_id).map(lead -> {
			followup.setLead(lead);
			return followupService.create(followup);
			}).orElseThrow(() -> new Exception("Lead id " + lead_id + " not found"));
	}
	
	@GetMapping("/lead/{lead_id}/followup/{id}")
    public Followup getFollowupByLeadIdandId(@PathVariable (value = "lead_id") Long lead_id, @PathVariable (value = "id") Long id) 
	{
        return followupService.getByLeadIdAndId(lead_id,id);
    }
	
	@PutMapping("/lead/{lead_id}/followup/{id}")	
    public Followup update(@PathVariable (value = "lead_id") Long lead_id,
                                 @PathVariable (value = "id") Long id,@Valid @RequestBody Followup followupRequest) throws Exception {
        if(!leadRepository.existsById(lead_id)) {
            throw new Exception("Lead id " + lead_id + " not found");
        }

        return followupRepository.findById(id).map(followup -> {
        	followup.setDescription(followupRequest.getDescription());
        	followup.setOrganizer(followupRequest.getOrganizer());
        	followup.setStarttime(followupRequest.getStarttime());
        	followup.setEndTime(followupRequest.getEndTime());
        	followup.setOwner(followupRequest.getOwner());
        	followup.setRemainer_period(followupRequest.getRemainer_period());
        	followup.setRecuring(followupRequest.isRecuring());
        	followup.setRecuring_period(followupRequest.getRecuring_period());
        	followup.setRemainder(followupRequest.isRemainder());
        	followup.setSubject(followupRequest.getSubject());
        	return followupRepository.save(followup);
        }).orElseThrow(() -> new Exception("Followup Id " + id + " not found"));
    }

    @DeleteMapping("/lead/{lead_id}/followup/{id}")	
    public ResponseEntity<?> deleteComment(@PathVariable (value = "lead_id") Long lead_id,
                              @PathVariable (value = "id") Long id) throws Exception {
        return followupRepository.findByIdAndLeadId(id, lead_id).map(followup -> {
        	followupRepository.delete(followup);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new Exception("Followup not found with id " + id + " and Leadid " + lead_id));
    }

}
