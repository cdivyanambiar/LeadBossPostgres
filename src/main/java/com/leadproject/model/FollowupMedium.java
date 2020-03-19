package com.leadproject.model;

public enum FollowupMedium
{
    Medium1 ("Medium1"),
    Medium2 ("Medium2");

    private final String followupMedium;

    FollowupMedium(final String followupMedium)
    {
        this.followupMedium = followupMedium;
    }

    public String value()
    {
        return followupMedium;
    }
}
