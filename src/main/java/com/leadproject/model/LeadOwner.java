package com.leadproject.model;

public enum LeadOwner
{
    LeadOwner1 ("LeadOwner1"),
    LeadOwner2 ("LeadOwner2");

    private final String leadOwner;

    LeadOwner(final String leadOwner)
    {
        this.leadOwner = leadOwner;
    }

    public String value()
    {
        return leadOwner;
    }
}
