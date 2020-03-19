package com.leadproject.model;

public enum OccupancyStatus
{
    OccupancyStatus1 ("OccupancyStatus1"),
    OccupancyStatus2 ("OccupancyStatus2");

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
