package com.dh.spring5webapp.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Project")
public class Project extends ModelBase {
    private String code;
    private String name;
    private String description;
    private String location;
    private boolean activate;
    private Date initDate;
    private Date endDate;
    private boolean deleted;

    @Lob
    private Byte[] image;

    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER, orphanRemoval = true, cascade = {CascadeType.REMOVE})
    private Set<AsignationProject> asignationProjectList = new HashSet<>();

    @Transient
    private Long asignationProjectId;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Set<AsignationProject> getAsignationProjectList() {
        return asignationProjectList;
    }

    public void setAsignationProjectList(Set<AsignationProject> asignationProjectList) {
        this.asignationProjectList = asignationProjectList;
    }

    public Long getAsignationProjectId() {
        return asignationProjectId;
    }

    public void setAsignationProjectId(Long asignationProjectId) {
        this.asignationProjectId = asignationProjectId;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
