package com.mathologic.project.SMARTSCHOOL.mongo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


@Document(collection = "trains")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Train implements Serializable {


    @Id
    @Indexed(direction = IndexDirection.ASCENDING)
    private String id;

    @Field
    @Size(max = 100)
    private int trainNo;

    @Field
    @Size(max = 100)
    private String trainName;

    @Field
    @Size(max = 100)
    private String fromStation;



    @DBRef
    private Station fromStationRef;

    @Field
    @Size(max = 100)
    private String toStation;


    @DBRef
    private Station toStationRef;



    @Field
    @Size(max = 100)
    private String runningDays;

    @Field
    @Size(max = 100)
    private String trainType;

    @Field
    @Size(max = 100)
    private boolean markDelete =false;

    @Size(max = 100)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdDateTime;


    public Train(int trainNo, String trainName, String fromStation, String toStation, String runningDays, String trainType, boolean markDelete, Date createdDateTime) {
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.runningDays = runningDays;
        this.trainType = trainType;
        this.markDelete = markDelete;
        this.createdDateTime = createdDateTime;
    }



    public Station getFromStationRef() {
        return fromStationRef;
    }

    public void setFromStationRef(Station fromStationRef) {
        this.fromStationRef = fromStationRef;
    }

    public Station getToStationRef() {
        return toStationRef;
    }

    public void setToStationRef(Station toStationRef) {
        this.toStationRef = toStationRef;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(int trainNo) {
        this.trainNo = trainNo;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public String getRunningDays() {
        return runningDays;
    }

    public void setRunningDays(String runningDays) {
        this.runningDays = runningDays;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public boolean isMarkDelete() {
        return markDelete;
    }

    public void setMarkDelete(boolean markDelete) {
        this.markDelete = markDelete;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }



}
