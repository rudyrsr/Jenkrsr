package com.dh.spring5webapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Incident")
public class Incident extends ModelBase {
    private String code;
    private String description;
    private String witness;
    private String place;
    private String observations;
    private boolean deleted;

    private Date registrationDate;
    @Lob
    private Byte[] image;
    @ManyToOne
    private Employee employee;

    @OneToOne(fetch = FetchType.LAZY)
    /*@JoinColumn(name = "incidentCatalog_id")*/
    private IncidentCatalog incidentCatalog;

    @Transient
    private Long incidentCatalogId;

    @Transient
    private Long employeeId;


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

    public String getWitness() {
        return witness;
    }

    public void setWitness(String witness) {
        this.witness = witness;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public IncidentCatalog getIncidentCatalog() {
        return incidentCatalog;
    }

    public void setIncidentCatalog(IncidentCatalog incidentCatalog) {
        this.incidentCatalog = incidentCatalog;
    }

    public Long getIncidentCatalogId() {
        return incidentCatalogId;
    }

    public void setIncidentCatalogId(Long incidentCatalogId) {
        this.incidentCatalogId = incidentCatalogId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
