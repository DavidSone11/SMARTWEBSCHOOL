package com.mathologic.project.SMARTSCHOOL.mongo.entity;



import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by Santosh on 2/16/18.
 */
@Document(collection ="station" )
@JsonIgnoreProperties(ignoreUnknown = true)

public class Station implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;


    @Id
    @Indexed(direction = IndexDirection.ASCENDING)
    private String id;


    @NotNull
    @Size(max = 100)
    @Field(value = "code")
    private String code;

    @NotNull
    @Size(max = 100)
    @Field(value = "name")
    private String name;

    @NotNull
    @Size(max = 10)
    @Field(value = "headStationSignOffDuration")
    private Long headStationSignOnDuration = 30L;

    @NotNull
    @Size(max = 10)
    @Field(value = "headStationSignOffDuration")
    private Long headStationSignOffDuration= 30L;

    @NotNull
    @Size(max = 10)
    @Field(value = "numberOfBeds")
    private Integer numberOfBeds= 1;

    @NotNull
    @Size(max = 10)
    @Field(value = "outStationSignOnDuration")
    private Long outStationSignOnDuration= 30L;

    @NotNull
    @Size(max = 10)
    @Field(value = "outStationSignOffDuration")
    private Long outStationSignOffDuration= 30L;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHeadStationSignOnDuration() {
        return headStationSignOnDuration;
    }

    public void setHeadStationSignOnDuration(Long headStationSignOnDuration) {
        this.headStationSignOnDuration = headStationSignOnDuration;
    }

    public Long getHeadStationSignOffDuration() {
        return headStationSignOffDuration;
    }

    public void setHeadStationSignOffDuration(Long headStationSignOffDuration) {
        this.headStationSignOffDuration = headStationSignOffDuration;
    }

    public Integer getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(Integer numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public Long getOutStationSignOnDuration() {
        return outStationSignOnDuration;
    }

    public void setOutStationSignOnDuration(Long outStationSignOnDuration) {
        this.outStationSignOnDuration = outStationSignOnDuration;
    }

    public Long getOutStationSignOffDuration() {
        return outStationSignOffDuration;
    }

    public void setOutStationSignOffDuration(Long outStationSignOffDuration) {
        this.outStationSignOffDuration = outStationSignOffDuration;
    }


}
