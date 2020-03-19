package com.leadproject.model;

public enum LeadPriority
{
    LeadPriority1 ("LeadPriority1"),
    LeadPriority2 ("LeadPriority2");

    private final String leadPriority;

    LeadPriority(final String leadPriority)
    {
        this.leadPriority = leadPriority;
    }

    public String value()
    {
        return leadPriority;
    }
}
