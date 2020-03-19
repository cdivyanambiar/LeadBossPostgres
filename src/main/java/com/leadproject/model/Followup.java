package com.leadproject.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Followup")
public class Followup
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne(mappedBy = "followup")
//    private Lead lead;

    private FollowupMedium followupMedium;
    private Date date;
    private String time;

    public Followup()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public Followup(FollowupMedium followupMedium, Date date, String time)
    {
        super();
        this.followupMedium = followupMedium;
        this.date = date;
        this.time = time;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public FollowupMedium getFollowupMedium()
    {
        return followupMedium;
    }

    public void setFollowupMedium(FollowupMedium followupMedium)
    {
        this.followupMedium = followupMedium;
    }

    public Date getDate()
    {
        return this.date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

}
