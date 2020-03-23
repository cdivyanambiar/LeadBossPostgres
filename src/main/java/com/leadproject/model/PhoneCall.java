package com.leadproject.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.leadproject.basemodel.CommunicationData;

@Entity
@Table(name = "PhoneCall")
public class PhoneCall extends CommunicationData
{
	 public PhoneCall()
	 {
	        super();
	        // TODO Auto-generated constructor stub
	 }

	public PhoneCall(String owner, Lead lead, String subject, Date starttime, String endTime, boolean recuring,
			String recuring_period, boolean remainder, String bremainer_period, String description, String organizer) 
	{
		super(owner, lead, subject, starttime, endTime, recuring, recuring_period, remainder, bremainer_period, description,
				organizer);
		// TODO Auto-generated constructor stub
	}

	
}
