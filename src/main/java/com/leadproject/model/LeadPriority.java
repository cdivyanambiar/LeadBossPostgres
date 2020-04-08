package com.leadproject.model;

public enum LeadPriority
{
	 
    Hot("Hot") ,
    Warm("Warm") ,
    Cold("Cold");

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
