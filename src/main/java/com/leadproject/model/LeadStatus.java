package com.leadproject.model;


public enum LeadStatus
{
	Prospect ("Prospect"),
	Followupcallmade ("Followup call made"),
	Followupcallrejected ("Followup call rejected"),
	Clinicalcallmade ("Clinical call made"),
	Clinicalrejection ("Clinical rejection"),
	Clinicalconversion("Clinical conversion");

    private final String leadStatus;

    LeadStatus(final String leadStatus)
    {
        this.leadStatus = leadStatus;
    }

    public String value()
    {
        return leadStatus;
    }
}
