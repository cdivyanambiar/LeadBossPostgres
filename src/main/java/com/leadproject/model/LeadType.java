package com.leadproject.model;

public enum LeadType
{
	 ProductEnquiry ("Product Enquiry"),
	 ResidentialTreatmentEnquiry ("Residential Treatment Enquiry");

    private final String leadType;

    LeadType(final String leadType)
    {
        this.leadType = leadType;
    }

    public String value()
    {
        return leadType;
    }
}
