package com.leadproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.leadproject.model.Email;
import com.leadproject.service.EmailService;


@RestController
public class EmailController 
{
	@Autowired
    private EmailService emailService;

    @PostMapping("/email")
    public String sendmail(@RequestBody Email email) 
    {

        emailService.sendMail(email);
        return "emailsent";
    }
    
    @GetMapping("/email/{id}")
    public Email getEmail(@PathVariable Long id)
    {
        return emailService.get(id);
    }

    @GetMapping("/emails")
    public List<Email> getLeads()
    {
        return emailService.getAll();
    }

    @DeleteMapping("/email/{id}")
    public void deleteEmail(@PathVariable Long id)
    {
    	emailService.delete(id);
    }

    @DeleteMapping("/emails")
    public void deleteEmails()
    {
    	emailService.deleteAll();
    }
}
