package com.leadproject.model;

public enum ClinicalIntensity
{
	Mild ("Mild"),
	Medium ("Medium"),
	Acute ("Acute");

    private final String clinicalIntensity;

    ClinicalIntensity(final String clinicalIntensity)
    {
        this.clinicalIntensity = clinicalIntensity;
    }

    public String value()
    {
        return clinicalIntensity;
    }
}