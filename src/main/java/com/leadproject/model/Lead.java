package com.leadproject.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Lead")
public class Lead
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LeadSource leadSource;
    private LeadType leadType;
    private Date dateOfAddition;
    private OccupancyStatus occupancyStatus;
    private LeadInterest leadInterest;
    private ClinicalIntensity clinicalIntensity;
    private String firstName;
    private String lastName;
    private Gender gender;

    private String emailAddress;
    private String phoneNumber;
    private String additionalNotes;

    //    @OneToOne(cascade=CascadeType.ALL)
    //    @JoinColumn(name = "additionalLeadDetails_id", nullable = false)
    //    @OnDelete(action = OnDeleteAction.CASCADE)
    //    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    //    @JsonIdentityReference(alwaysAsId = true)
    //    @JsonProperty("additionalLeadDetails_id")
    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "additionalLeadDetails_id")
    private AdditionalLeadDetails additionalLeadDetails;

    //    @OneToOne(cascade=CascadeType.ALL)
    //    @JoinColumn(name = "followup_id", nullable = false)
    //    @OnDelete(action = OnDeleteAction.CASCADE)
    //    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    //    @JsonIdentityReference(alwaysAsId = true)
    //    @JsonProperty("followup_id")
    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "followup_id")
    private Followup followup;

    public Lead()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public Lead(
            LeadSource leadSource,
            LeadType leadType,
            Date dateOfAddition,
            OccupancyStatus occupancyStatus,
            LeadInterest leadInterest,
            ClinicalIntensity clinicalIntensity,
            String firstName,
            String lastName,
            Gender gender,
            String emailAddress,
            String phoneNumber,
            String additionalNotes,
            AdditionalLeadDetails additionalLeadDetails,
            Followup followup)
    {
        super();
        this.leadSource = leadSource;
        this.leadType = leadType;
        this.dateOfAddition = dateOfAddition;
        this.occupancyStatus = occupancyStatus;
        this.leadInterest = leadInterest;
        this.clinicalIntensity = clinicalIntensity;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.additionalNotes = additionalNotes;
        this.additionalLeadDetails = additionalLeadDetails;
        this.followup = followup;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public LeadSource getLeadSource()
    {
        return leadSource;
    }

    public void setLeadSource(LeadSource leadSource)
    {
        this.leadSource = leadSource;
    }

    public LeadType getLeadType()
    {
        return leadType;
    }

    public void setLeadType(LeadType leadType)
    {
        this.leadType = leadType;
    }

    public Date getDateOfAddition()
    {
        return dateOfAddition;
    }

    public void setDateOfAddition(Date dateOfAddition)
    {
        this.dateOfAddition = dateOfAddition;
    }

    public OccupancyStatus getOccupancyStatus()
    {
        return occupancyStatus;
    }

    public void setOccupancyStatus(OccupancyStatus occupancyStatus)
    {
        this.occupancyStatus = occupancyStatus;
    }

    public LeadInterest getLeadInterest()
    {
        return leadInterest;
    }

    public void setLeadInterest(LeadInterest leadInterest)
    {
        this.leadInterest = leadInterest;
    }

    public ClinicalIntensity getClinicalIntensity()
    {
        return clinicalIntensity;
    }

    public void setClinicalIntensity(ClinicalIntensity clinicalIntensity)
    {
        this.clinicalIntensity = clinicalIntensity;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Gender getGender()
    {
        return gender;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getAdditionalNotes()
    {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes)
    {
        this.additionalNotes = additionalNotes;
    }

    public AdditionalLeadDetails getAdditionalLeadDetails()
    {
        return additionalLeadDetails;
    }

    public void setAdditionalLeadDetails(AdditionalLeadDetails additionalLeadDetails)
    {
        this.additionalLeadDetails = additionalLeadDetails;
    }

    public Followup getFollowup()
    {
        return followup;
    }

    public void setFollowup(Followup followup)
    {
        this.followup = followup;
    }

}
