
package com.dh.spring5webapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Funtional_Manual")
public class FuntionalManual extends ModelBase {
    private String code;
    private Date date;
    private String name;
    private String description;
    private String url;
    private String OrganitationalLevel;
    private String EducationLevel;

    @OneToOne(orphanRemoval = true, fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    private Position position;

    private boolean deleted = false;

    @Transient
    private Long positionid;

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getPositionid() {
        return positionid;
    }

    public void setPositionid(Long positionid) {
        this.positionid = positionid;
    }

    public String getOrganitationalLevel() {
        return OrganitationalLevel;
    }

    public String getEducationLevel() {
        return EducationLevel;
    }

    public void setOrganitationalLevel(String organitationalLevel) {
        OrganitationalLevel = organitationalLevel;
    }

    public void setEducationLevel(String educationLevel) {
        EducationLevel = educationLevel;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}