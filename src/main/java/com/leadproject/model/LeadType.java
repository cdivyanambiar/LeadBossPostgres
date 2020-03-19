package com.leadproject.model;

public enum LeadType
{
    LeadType1 ("LeadType1"),
    LeadType2 ("LeadType2");

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
