package com.leadproject.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.leadproject.model.Email;
import com.leadproject.repository.EmailRepository;


@Service
public class EmailService 
{
	@Autowired
	private EmailRepository emailRepository;

	@Autowired
	private JavaMailSender javaMailSender;

    public Email sendMail(Email email) 
    {    	
    	SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(email.getSendTo());
		mailMessage.setFrom(email.getSendFrom());
		mailMessage.setSubject(email.getSubject());
		mailMessage.setText(email.getMessage());   
        javaMailSender.send(mailMessage);
        
        return emailRepository.save(email);
        
    }
    
    public List<Email> getAll()
    {
        return emailRepository.findAll();
    }
    
    public Email get(Long id)
    {
        Optional<Email> email = emailRepository.findById(id);
        if (email.isPresent())
        {
            return email.get();
        }
        else
        {
            return null;
        }
    }
    
    public void deleteAll()
    {
    	emailRepository.deleteAll();
    }

    public void delete(Long id)
    {
        Optional<Email> email = emailRepository.findById(id);
        if (email.isPresent())
        {
        	emailRepository.delete(email.get());
        }
    }
}
