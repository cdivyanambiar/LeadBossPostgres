package com.leadproject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	

	@PostMapping("/lead/{lead_id}/salesactivity")
	public SalesActivity create(@PathVariable (value = "lead_id") Long lead_id,
			@Valid @RequestBody SalesActivity salesActivity) throws Exception {
		return leadRepository.findById(lead_id).map(lead -> {
			salesActivity.setLead(lead);
			return salesActivityService.create(salesActivity);
			}).orElseThrow(() -> new Exception("Lead id " + lead_id + " not found"));
	
	}
}
