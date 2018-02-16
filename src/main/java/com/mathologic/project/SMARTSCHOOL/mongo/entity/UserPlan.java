package com.mathologic.project.SMARTSCHOOL.mongo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;



/**
 *  Created by Santosh on 2/16/18.
 */



@Document(collection = "UserPlan")
@JsonIgnoreProperties(ignoreUnknown = true)

public class UserPlan implements Serializable {


    @Size(max = 100)
    @NotNull
    @Field(value = "planName")
    private String planName;




    @Field(value = "isComplete")
    private boolean isUnderReview;


    @Field(value = "isLocked")
    private boolean isLocked;

    @Size(max = 100)
    @Field(value = "coPlanners")
    private String coPlanners;

    @Size(max = 100)
    @Field(value = "reviewer")
    private String reviewer;

    @Size(max = 100)
    @Field(value = "owner")
    private String owner;


    @Field(value = "markDelete")
    private boolean markDelete = Boolean.FALSE;


    @Field(value = "createdTime")
    private Date createdTime = new Date();



    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }



    public boolean isUnderReview() {
        return isUnderReview;
    }

    public void setUnderReview(boolean underReview) {
        isUnderReview = underReview;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public String getCoPlanners() {
        return coPlanners;
    }

    public void setCoPlanners(String coPlanners) {
        this.coPlanners = coPlanners;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isMarkDelete() {
        return markDelete;
    }

    public void setMarkDelete(boolean markDelete) {
        this.markDelete = markDelete;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }





}
