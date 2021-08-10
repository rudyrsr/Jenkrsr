/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.Incident;
import com.dh.spring5webapp.model.ModelBase;
import org.apache.tomcat.util.codec.binary.Base64;

import java.util.Date;


public class IncidentCommand extends ModelBase {

    private String incidentCode;
    private String insidentDescription;
    private String incidentLabel;
    private Long employeeId;
    private String incidentObsevations;
    private String image;
    private String incidentWitness;
    private String incidentPlace;
    private Date incidentRegDate;
    private Long inicentCatalogId;
    private boolean deleted;

    private EmployeeCommand employeeCM;
    private IncidentCatalogCommand incidentCatalogCommandCM;


    public IncidentCommand(Incident incident) {

        this.setInicentCatalogId(incident.getIncidentCatalog().getId());
        this.setId(incident.getId());
        this.setIncidentCode(incident.getCode());
        this.setInsidentDescription(incident.getDescription());
        this.setIncidenLabel(incident.getCode());
        this.setIncidentObsevations(incident.getObservations());
        this.setEmployeeId(incident.getEmployee().getId());
        if (incident.getImage() != null) {
            byte[] bytes = new byte[incident.getImage().length];
            for (int i = 0; i < incident.getImage().length; i++) {
                bytes[i] = incident.getImage()[i];
            }
            String imageStr = Base64.encodeBase64String(bytes);
            this.setImage(imageStr);
        }
        this.setCreatedOn(incident.getCreatedOn());
        this.setUpdatedOn(incident.getUpdatedOn());
        this.setIncidentPlace(incident.getPlace());
        this.setIncidentWitness(incident.getWitness());
        this.setIncidentRegDate(incident.getRegistrationDate());
        this.setEmployeeCM(new EmployeeCommand(incident.getEmployee()));
        this.setIncidentCatalogCommandCM(new IncidentCatalogCommand(incident.getIncidentCatalog()));
        this.setDeleted(incident.isDeleted());
    }

    public IncidentCommand() {
    }

    public String getIncidentCode() {
        return incidentCode;
    }

    public void setIncidentCode(String incidentCode) {
        this.incidentCode = incidentCode;
    }

    public String getInsidentDescription() {
        return insidentDescription;
    }

    public void setInsidentDescription(String insidentDescription) {
        this.insidentDescription = insidentDescription;
    }

    public String getIncidenLabel() {
        return incidentLabel;
    }

    public void setIncidenLabel(String incidenLabel) {
        this.incidentLabel = getIncidentCode() + "-" + getId();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getIncidentObsevations() {
        return incidentObsevations;
    }

    public void setIncidentObsevations(String incidentObsevations) {
        this.incidentObsevations = incidentObsevations;
    }

    public String getIncidentWitness() {
        return incidentWitness;
    }

    public void setIncidentWitness(String incidentWitness) {
        this.incidentWitness = incidentWitness;
    }

    public String getIncidentPlace() {
        return incidentPlace;
    }

    public void setIncidentPlace(String incidentPlace) {
        this.incidentPlace = incidentPlace;
    }

    public Date getIncidentRegDate() {
        return incidentRegDate;
    }

    public void setIncidentRegDate(Date incidentRegDate) {
        this.incidentRegDate = incidentRegDate;
    }

    public Long getInicentCatalogId() {
        return inicentCatalogId;
    }

    public void setInicentCatalogId(Long inicentCatalogId) {
        this.inicentCatalogId = inicentCatalogId;
    }

    public EmployeeCommand getEmployeeCM() {
        return employeeCM;
    }

    public void setEmployeeCM(EmployeeCommand employeeCM) {
        this.employeeCM = employeeCM;
    }

    public IncidentCatalogCommand getIncidentCatalogCommandCM() {
        return incidentCatalogCommandCM;
    }

    public void setIncidentCatalogCommandCM(IncidentCatalogCommand incidentCatalogCommandCM) {
        this.incidentCatalogCommandCM = incidentCatalogCommandCM;
    }

    public String getIncidentLabel() {
        return incidentLabel;
    }

    public void setIncidentLabel(String incidentLabel) {
        this.incidentLabel = incidentLabel;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Incident toDomain() {
        Incident incident = new Incident();
        incident.setCode(getIncidentCode());
        incident.setId(getId());
        incident.setDescription(getInsidentDescription());
        incident.setObservations(getIncidentObsevations());
        incident.setCreatedOn(getCreatedOn());
        incident.setUpdatedOn(getUpdatedOn());
        incident.setWitness(getIncidentWitness());
        incident.setPlace(getIncidentPlace());
        incident.setRegistrationDate(getIncidentRegDate());
        incident.setEmployeeId(getEmployeeId());
        incident.setIncidentCatalogId(getInicentCatalogId());

        return incident;
    }
}
