package com.leadproject.model;

public enum LeadInterest
{
	Panchakarma ("Panchakarma"),
	Spine ("Spine"),
	Rehabilitation ("Rehabilitation"),
	DigestiveDisorder ("Digestive Disorder"),
	GynaecologicalDisorders ("Gynaecological Disorders");

    private final String leadInterest;

    LeadInterest(final String leadInterest)
    {
        this.leadInterest = leadInterest;
    }

    public String value()
    {
        return leadInterest;
    }
}
