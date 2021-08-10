package com.dh.spring5webapp.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Machinery")
public class Machinery extends ModelBase {
    private String code;
    private String name;
    private Date dateBuy;
    private Integer available;
    private String brand;
    private Double price;
    private boolean deleted = false;



    @Lob
    private Byte[] image;
    @OneToMany(mappedBy = "machinery", fetch = FetchType.EAGER, orphanRemoval = true, cascade = {CascadeType.ALL})
    private Set<Maintenance> maintenanceList = new HashSet<>();

    @OneToMany(mappedBy = "machinery", orphanRemoval = true, fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    private Set<MachineryAssignation> machineryAssignations = new HashSet<>();

    @Transient
    private Long machineryAssignationsid;

    @Transient
    private Long maintenanceid;

    @OneToOne(fetch = FetchType.LAZY)
    private MachineryCatalog machineryCatalog;

    @Transient
    private Long machineryCatalogid;


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

    public Date getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(Date dateBuy) {
        this.dateBuy = dateBuy;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public void setMachineryCatalogid(Long machineryCatalogid) {
        this.machineryCatalogid = machineryCatalogid;
    }

    public MachineryCatalog getMachineryCatalog() {
        return machineryCatalog;
    }

    public void setMachineryCatalog(MachineryCatalog machineryCatalog) {
        this.machineryCatalog = machineryCatalog;
    }

    public Long getMaintenanceid() {
        return maintenanceid;
    }

    public void setMaintenanceid(Long maintenanceid) {
        this.maintenanceid = maintenanceid;
    }

    public Long getMachineryCatalogid() {
        return machineryCatalogid;
    }

    public Set<Maintenance> getMaintenanceList() {
        return maintenanceList;
    }

    public void setMaintenanceList(Set<Maintenance> maintenanceList) {
        this.maintenanceList = maintenanceList;
    }

    public Set<MachineryAssignation> getMachineryAssignations() {
        return machineryAssignations;
    }

    public void setMachineryAssignations(Set<MachineryAssignation> machineryAssignations) {
        this.machineryAssignations = machineryAssignations;
    }

    public Long getMachineryAssignationsid() {
        return machineryAssignationsid;
    }

    public void setMachineryAssignationsid(Long machineryAssignationsid) {
        this.machineryAssignationsid = machineryAssignationsid;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
