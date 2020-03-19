package com.leadproject.model;

public enum LeadInterest
{
    LeadInterest1 ("LeadInterest"),
    LeadInterest2 ("LeadInterest2");

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
