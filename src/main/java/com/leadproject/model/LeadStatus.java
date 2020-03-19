package com.leadproject.model;

public enum LeadStatus
{
    LeadStatus1 ("LeadStatus1"),
    LeadStatus2 ("LeadStatus2");

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
