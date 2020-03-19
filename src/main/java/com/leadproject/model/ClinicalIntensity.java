package com.leadproject.model;

public enum ClinicalIntensity
{
    ClinicalIntensity1 ("ClinicalIntensity1"),
    ClinicalIntensity2 ("ClinicalIntensity2");

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
