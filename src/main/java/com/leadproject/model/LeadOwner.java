package com.leadproject.model;

public enum LeadOwner
{
	NithinKrishna ("Nithin Krishna"),
	FyrozHaneefa ("Fyroz Haneefa"),
	AshikSajeevan ("Ashik Sajeevan");

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
