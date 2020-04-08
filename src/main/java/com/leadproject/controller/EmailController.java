package com.leadproject.controller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leadproject.model.Email;
import com.leadproject.service.EmailService;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/rest")
public class EmailController 
{
	@Autowired
    private EmailService emailService;

    @PostMapping("/email")
    public String sendmail(@RequestBody Email email) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, MessagingException, IOException, TemplateException 
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
