package com.leadproject.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.leadproject.model.SalesActivity;
import com.leadproject.repository.LeadRepository;
import com.leadproject.service.SalesActivityService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rest")
public class SalesActivityController {

	@Autowired
	private SalesActivityService salesActivityService;
	
	@Autowired
	private LeadRepository leadRepository;
	
	@GetMapping("/lead/{lead_id}/salesactivity")
    public List<SalesActivity> getAllFollowupsByLeadId(@PathVariable (value = "lead_id") Long lead_id) 
	{
        return salesActivityService.findByLeadId(lead_id);
    }

	@PostMapping("/lead/{lead_id}/salesactivity")
	public SalesActivity create(@PathVariable (value = "lead_id") Long lead_id,
			@Valid @RequestBody SalesActivity salesActivity) throws Exception {
		return leadRepository.findById(lead_id).map(lead -> {
			salesActivity.setLead(lead);
			return salesActivityService.create(salesActivity);
			}).orElseThrow(() -> new Exception("Lead id " + lead_id + " not found"));
	
	}
	
	@GetMapping("/lead/{lead_id}/salesactivity/{id}")
    public SalesActivity getFollowupByLeadIdandId(@PathVariable (value = "lead_id") Long lead_id, @PathVariable (value = "id") Long id) 
	{
        return salesActivityService.getByLeadIdAndId(lead_id,id);
    }
	
	@PutMapping("/lead/{lead_id}/salesactivity/{id}")	
    public SalesActivity update(@PathVariable (value = "lead_id") Long lead_id,
                                 @PathVariable (value = "id") Long id,@Valid @RequestBody SalesActivity activityRequest) throws Exception {
        if(!leadRepository.existsById(lead_id)) {
            throw new Exception("Lead id " + lead_id + " not found");
        }

        return salesActivityService.update(activityRequest, id);
    }

    @DeleteMapping("/salesactivity/{id}")	
    public void deleteComment(@PathVariable (value = "id") Long id) throws Exception {
       salesActivityService.delete(id);
    }
	
}
