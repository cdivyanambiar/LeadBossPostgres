package com.leadproject.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Email")
public class Email 
{
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

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
	 
	 public Email(String sendTo,String sendFrom, String subject, Date dateOfEmail, String message) 
	 {
		super();
		this.sendTo = sendTo;
		this.sendFrom = sendFrom;
		this.subject = subject;
		this.dateOfEmail = dateOfEmail;
		this.message = message;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public String getSendTo() {
		return sendTo;
	}
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
	public String getSendFrom() {
		return sendFrom;
	}
	public void setSendFrom(String sendFrom) {
		this.sendFrom = sendFrom;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getDateOfEmail() {
		return dateOfEmail;
	}
	public void setDateOfEmail(Date dateOfEmail) {
		this.dateOfEmail = dateOfEmail;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	 
}
