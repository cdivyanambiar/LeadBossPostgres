package com.leadproject.basemodel;

import java.util.Date;


import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leadproject.model.Lead;
@MappedSuperclass
public abstract class CommunicationData 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String owner;    
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lead_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Lead lead;
    
    private String subject;
    private Date starttime;
    private String endTime;
    private boolean recuring;  
    private String recuring_period; 
    private boolean remainder; 
    private String remainer_period; 
    private String description; 
    private String organizer;
    
	public CommunicationData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommunicationData(String owner, Lead lead, String subject,
			Date starttime, String endTime,
			boolean recuring, String recuring_period, boolean remainder, String bremainer_period, String description,
			String organizer
			) 
	{
		super();
		this.owner = owner;
		this.lead = lead;
		this.subject = subject;
		this.starttime = starttime;
		this.endTime = endTime;
		this.recuring = recuring;
		this.recuring_period = recuring_period;
		this.remainder = remainder;
		this.remainer_period = bremainer_period;
		this.description = description;
		this.organizer = organizer;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Lead getLead() {
		return lead;
	}
	public void setLead(Lead lead) {
		this.lead = lead;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public boolean isRecuring() {
		return recuring;
	}
	public void setRecuring(boolean recuring) {
		this.recuring = recuring;
	}
	public String getRecuring_period() {
		return recuring_period;
	}
	public void setRecuring_period(String recuring_period) {
		this.recuring_period = recuring_period;
	}
	public boolean isRemainder() {
		return remainder;
	}
	public void setRemainder(boolean remainder) {
		this.remainder = remainder;
	}
	public String getRemainer_period() {
		return remainer_period;
	}
	public void setRemainer_period(String remainer_period) {
		this.remainer_period = remainer_period;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOrganizer() {
		return organizer;
	}
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	} 
}
