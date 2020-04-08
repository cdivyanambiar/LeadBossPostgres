package com.leadproject.model;

public enum LeadSource
{	
	OrganicSearch ("OrganicSearch"),
	OnlineChat ("Online Chat"),
	InboundPhonecall ("Inbound Phone call"),
	InboundEmail ("Inbound Email"),
	SocialMedia ("Social Media"),
	PatientReferral ("Patient Referra"),
	DoctorReferral ("Doctor Referral"),
	Other ("Other");

    private final String leadSource;

    LeadSource(final String leadSource)
    {
        this.leadSource = leadSource;
    }

    public String value()
    {
        return leadSource;
    }
}
