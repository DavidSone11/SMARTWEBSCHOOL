package com.mathologic.project.SMARTSCHOOL.mongo.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Document(collection = "users")
@TypeAlias("users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Indexed(direction = IndexDirection.ASCENDING)
    private ObjectId id;

    @NotNull
    @Field(value = "username")
    @Indexed(direction = IndexDirection.ASCENDING,name = "username",unique = true)
    private String username;


    @Field(value = "password")
    private String password;

    @Size(max = 100)
    @NotNull
    @Field(value = "firstName")
    private String firstName;

    @Size(max = 100)
    @Field(value = "lastName")
    private String lastName;

    @Size(max = 100)
    @Field(value = "email")
    private String email;

    @Size(max = 10)
    @Field(value = "mobileNo")
    private String mobileNo;

    @Size(max = 10)
    @Field(value = "telephoneNo")
    private String telephoneNo;


    @Size(max = 100)
    @Field(value = "extension")
    private String extension;

    @Size(max = 2)
    @Field(value = "isActive")
    private boolean isActive = Boolean.FALSE;

    @Size(max = 100)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdDateTime;



    @Size(max = 10)
    @Field(value = "role")
    private String role;



    public User(String username, String password,String email,String telephoneNo,String extension,String firstName,String lastName,boolean isActive,Date createdDateTime,String role) {
        this.username = username;
        this.password =password;
        this.email = email;
        this.telephoneNo = telephoneNo;
        this.extension = extension;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.createdDateTime = createdDateTime;
        this.role = role;
    }



    public ObjectId  getId() {
        return id;
    }

    public void setId(ObjectId  id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
