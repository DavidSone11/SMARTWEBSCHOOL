package com.mathologic.project.SMARTSCHOOL.mongo.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import javax.validation.constraints.Size;
import java.io.Serializable;

@Document(collection = "roles")
@JsonIgnoreProperties(ignoreUnknown = true)
@TypeAlias("roles")

public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isMarkDelete() {
        return markDelete;
    }

    public void setMarkDelete(boolean markDelete) {
        this.markDelete = markDelete;
    }

    @Id
    @Indexed(direction = IndexDirection.ASCENDING)
    private String id;


    @Size(max = 100)
    @Field(value = "markDelete")
    private boolean markDelete = Boolean.FALSE;

    public Role() {
    }

    public Role(String rolename) {
        this.rolename = rolename;
    }

    @Indexed(direction = IndexDirection.ASCENDING,name = "rolename",unique = true)
    private String rolename;


    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
