package com.dh.spring5webapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Maintenance")
public class Maintenance extends ModelBase {

    private String code;
    private String description;
    private String observation;
    private Double price;
    private Date timelineinitdate;
    private Date timelineenddate;
    private boolean deleted = false;


    @ManyToOne(optional = false,fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    private Machinery machinery;

    @Transient
    private Long machineryid;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Machinery getMachinery() {
        return machinery;
    }

    public void setMachinery(Machinery machinery) {
        this.machinery = machinery;
    }

    public Long getMachineryid() {
        return machineryid;
    }

    public void setMachineryid(Long machineryid) {
        this.machineryid = machineryid;
    }


    public Date getTimelineinitdate() {
        return timelineinitdate;
    }

    public void setTimelineinitdate(Date timelineinitdate) {
        this.timelineinitdate = timelineinitdate;
    }

    public Date getTimelineenddate() {
        return timelineenddate;
    }

    public void setTimelineenddate(Date timelineenddate) {
        this.timelineenddate = timelineenddate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
