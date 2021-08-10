package com.dh.spring5webapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Affliction")
public class Affliction extends ModelBase {
    private String code;
    private String name;
    private String description;
    private String observation;
    private Date registrationDate;
    private boolean deleted = false;

    @OneToOne(fetch = FetchType.EAGER)
    private AfflictionCatalog afflictionCatalog;

    @ManyToOne(fetch = FetchType.EAGER)
    private Employee employee;

    @Transient
    private Long afflictionCatalogId;

    @Transient
    private Long employeeId;

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

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public AfflictionCatalog getAfflictionCatalog() {
        return afflictionCatalog;
    }

    public void setAfflictionCatalog(AfflictionCatalog afflictionCatalog) {
        this.afflictionCatalog = afflictionCatalog;
    }

    public Long getAfflictionCatalogId() {
        return afflictionCatalogId;
    }

    public void setAfflictionCatalogId(Long afflictionCatalogId) {
        this.afflictionCatalogId = afflictionCatalogId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
