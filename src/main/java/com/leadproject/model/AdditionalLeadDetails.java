package com.leadproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "AdditionalLeadDetails")
public class AdditionalLeadDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne(mappedBy = "additionalLeadDetails")
//    private Lead lead;

    private LeadPriority leadPriority;
    private LeadStatus leadStatus;
    private LeadOwner leadOwner;

    public AdditionalLeadDetails()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public AdditionalLeadDetails(LeadPriority leadPriority, LeadStatus leadStatus, LeadOwner leadOwner)
    {
        super();
        this.leadPriority = leadPriority;
        this.leadStatus = leadStatus;
        this.leadOwner = leadOwner;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public LeadPriority getLeadPriority()
    {
        return leadPriority;
    }

    public void setLeadPriority(LeadPriority leadPriority)
    {
        this.leadPriority = leadPriority;
    }

    public LeadStatus getLeadStatus()
    {
        return leadStatus;
    }

    public void setLeadStatus(LeadStatus leadStatus)
    {
        this.leadStatus = leadStatus;
    }

    public LeadOwner getLeadOwner()
    {
        return leadOwner;
    }

    public void setLeadOwner(LeadOwner leadOwner)
    {
        this.leadOwner = leadOwner;
    }

}
