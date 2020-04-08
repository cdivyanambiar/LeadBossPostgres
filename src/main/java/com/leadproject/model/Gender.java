package com.leadproject.model;

public enum Gender
{
    Male ("Male"),
    Female ("Female"),
    Other ("Other");

    private final String gender;

    Gender(final String gender)
    {
        this.gender = gender;
    }

    public String value()
    {
        return gender;
    }
}
