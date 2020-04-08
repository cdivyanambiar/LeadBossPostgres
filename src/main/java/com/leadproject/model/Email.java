package com.leadproject.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Email")
public class Email 
{
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 private transient Map<String, String> model;
	 private String name;
	 private String sendTo;
	 private String sendFrom;
	 private String subject;
	 private Date dateOfEmail;
	 private String message;
	 
	 public Email()
     {
        super();
        // TODO Auto-generated constructor stub
     }
	 
	 public Email(String name,String sendTo,String sendFrom, String subject, Date dateOfEmail, String message) 
	 {
		super();
		this.name = name;
		this.sendTo = sendTo;
		this.sendFrom = sendFrom;
		this.subject = subject;
		this.dateOfEmail = dateOfEmail;
		this.message = message;
	}	
	 
}
