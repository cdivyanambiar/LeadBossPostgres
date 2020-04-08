package com.leadproject.service;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.leadproject.model.Email;
import com.leadproject.repository.EmailRepository;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;


@Service
public class EmailService 
{
	@Autowired
	private EmailRepository emailRepository;

	@Autowired
	private JavaMailSender javaMailSender;
	
    @Resource(name = "emailConfigBean")
    private Configuration emailConfig;

	public Email sendMail(Email email) throws MessagingException, TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		Map model = new HashMap();
		model.put("name", email.getName());
		model.put("location", "Sri Lanka");
		model.put("signature", "https://techmagister.info");
		model.put("content", email.getMessage());

		email.setModel(model);

		//#log.info("Sending Email to: " + email.getTo());

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message,
				MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
		mimeMessageHelper.addInline("logo.png", new ClassPathResource("classpath:/techmagisterLogo.png"));

		Template template = emailConfig.getTemplate("email.ftl");
		String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, email.getModel());

		mimeMessageHelper.setTo(email.getSendTo());
		mimeMessageHelper.setText(html, true);
		mimeMessageHelper.setSubject(email.getMessage());
		mimeMessageHelper.setFrom(email.getSendFrom());

		javaMailSender.send(message);
		
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
