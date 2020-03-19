package com.leadproject.model;

public enum LeadSource
{
    LeadSource1 ("LeadSource1"),
    LeadSource2 ("LeadSource2");

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
