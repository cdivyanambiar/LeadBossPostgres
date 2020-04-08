package com.leadproject.model;

public enum OccupancyStatus
{
    DSO ("DSO"),
    FSO ("FSO"),
    FSQ ("FSQ");

    private final String occupancyStatus;

    OccupancyStatus(final String occupancyStatus)
    {
        this.occupancyStatus = occupancyStatus;
    }

    public String value()
    {
        return occupancyStatus;
    }
}
