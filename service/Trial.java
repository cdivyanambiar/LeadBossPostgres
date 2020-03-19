package com.example.demo.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import com.example.demo.model.AdditionalLeadDetails;
import com.example.demo.model.ClinicalIntensity;
import com.example.demo.model.Followup;
import com.example.demo.model.FollowupMedium;
import com.example.demo.model.Gender;
import com.example.demo.model.Lead;
import com.example.demo.model.LeadInterest;
import com.example.demo.model.LeadOwner;
import com.example.demo.model.LeadPriority;
import com.example.demo.model.LeadSource;
import com.example.demo.model.LeadStatus;
import com.example.demo.model.LeadType;
import com.example.demo.model.OccupancyStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Trial
{
    public static void main(String[] args)
            throws JsonProcessingException
    {
        String date = "2020-02-28";
        String pattern = "yyyy-MM-dd";
        LocalDate ldate = LocalDate.parse(date);

        System.out.println(ldate);
        ObjectMapper mapper = new ObjectMapper();
        Lead l = new Lead(
                LeadSource.LeadSource1,
                LeadType.LeadType1,
                new Date("2020-02-27"),
                OccupancyStatus.OccupancyStatus1,
                LeadInterest.LeadInterest1,
                ClinicalIntensity.ClinicalIntensity1,
                "Vikrant",
                "Dhimate",
                Gender.Male,
                "vikrant@gmail.com",
                "1111111111",
                "Good",
                new AdditionalLeadDetails(LeadPriority.LeadPriority1, LeadStatus.LeadStatus1, LeadOwner.LeadOwner1),
                new Followup(FollowupMedium.Medium1, new Date("2020-02-27"), "10.00 AM"));
        String jsonInString = mapper.writeValueAsString(l);
        System.out.println(jsonInString);
    }
}
