package com.leadproject.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "SalesActivity")
public class SalesActivity 
{	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "lead_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Lead lead;
	
    private String product; 
    private LeadStatus status;  
    private LeadOwner owner;  
    private Date salesDate;
    
	public SalesActivity() {
		super();
	} 
    
    
	public SalesActivity(Lead lead, String product, LeadStatus status, LeadOwner owner, Date salesDate) {
		super();
		this.lead = lead;
		this.product = product;
		this.status = status;
		this.owner = owner;
		this.salesDate = salesDate;
	}



    
}
