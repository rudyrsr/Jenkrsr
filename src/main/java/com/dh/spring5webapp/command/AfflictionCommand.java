
package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.Affliction;
import com.dh.spring5webapp.model.ModelBase;

import java.util.Date;


public class AfflictionCommand extends ModelBase {

    private String afflictionName;
    private String afflictionCode;
    private String afflictionDescription;
    private String afflictionObservation;
    private Date afflictionRegDate;
    private String afflictionLabel;
    private Long employeeId;
    private Long afflictionCatalogId;
    private boolean deleted;

    private EmployeeCommand employeeCommand;

    private AfflictionCatalogCommand afflictionCatalogCM;


    public AfflictionCommand(Affliction affliction) {

        this.setId(affliction.getId());
        this.setAfflictionName(affliction.getName());
        this.setAfflictionCode(affliction.getCode());
        this.setAfflictionDescription(affliction.getDescription());
        this.setAfflictionObservation(affliction.getObservation());
        this.setEmployeeId(affliction.getEmployee().getId());
        this.setAfflictionCatalogId(affliction.getAfflictionCatalog().getId());
        this.setAfflictionRegDate(affliction.getRegistrationDate());
        this.setAfflictionLabel(affliction.getCode());
        this.setEmployeeId(getEmployeeId());
        this.setCreatedOn(affliction.getCreatedOn());
        this.setUpdatedOn(affliction.getUpdatedOn());
        //System.out.println("the value of " + affliction.getEmployee().getId());
        this.setEmployeeCommand(new EmployeeCommand(affliction.getEmployee()));
        this.setAfflictionCatalogCM(new AfflictionCatalogCommand(affliction.getAfflictionCatalog()));
        this.setDeleted(affliction.isDeleted());
        //this.setAfflictionCatalog(affliction.getAfflictionCatalog());*/
    }

    public AfflictionCommand() {
    }

    public String getAfflictionName() {
        return afflictionName;
    }

    public void setAfflictionName(String afflictionName) {
        this.afflictionName = afflictionName;
    }

    public String getAfflictionCode() {
        return afflictionCode;
    }

    public void setAfflictionCode(String afflictionCode) {
        this.afflictionCode = afflictionCode;
    }

    public String getAfflictionDescription() {
        return afflictionDescription;
    }

    public void setAfflictionDescription(String afflictionDescription) {
        this.afflictionDescription = afflictionDescription;
    }

    public String getAfflictionObservation() {
        return afflictionObservation;
    }

    public void setAfflictionObservation(String afflictionObsevations) {
        this.afflictionObservation = afflictionObsevations;
    }

    public Date getAfflictionRegDate() {
        return afflictionRegDate;
    }

    public void setAfflictionRegDate(Date afflictionRegDate) {
        this.afflictionRegDate = afflictionRegDate;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getAfflictionLabel() {
        return afflictionLabel;
    }

    public void setAfflictionLabel(String incidenLabel) {
        this.afflictionLabel = getAfflictionCode() + "-" + getId();
    }

    public Long getAfflictionCatalogId() {
        return afflictionCatalogId;
    }

    public void setAfflictionCatalogId(Long afflictionCatalogId) {
        this.afflictionCatalogId = afflictionCatalogId;
    }

    public EmployeeCommand getEmployeeCommand() {
        return employeeCommand;
    }

    public void setEmployeeCommand(EmployeeCommand employeeCommand) {
        this.employeeCommand = employeeCommand;
    }

    public AfflictionCatalogCommand getAfflictionCatalogCM() {
        return afflictionCatalogCM;
    }

    public void setAfflictionCatalogCM(AfflictionCatalogCommand afflictionCatalogCM) {
        this.afflictionCatalogCM = afflictionCatalogCM;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Affliction toDomain() {
        Affliction affliction = new Affliction();
        affliction.setId(getId());
        affliction.setCode(getAfflictionCode());
        affliction.setName(getAfflictionName());
        affliction.setDescription(getAfflictionDescription());
        affliction.setObservation(getAfflictionObservation());
        affliction.setCreatedOn(getCreatedOn());
        affliction.setUpdatedOn(getUpdatedOn());
        affliction.setRegistrationDate(getAfflictionRegDate());
        affliction.setEmployeeId(getEmployeeId());
        affliction.setAfflictionCatalogId(getAfflictionCatalogId());
        //affliction.setEmployee(getEmployeeCommand().toEmployee());
        //affliction.setAfflictionCatalog(getAfflictionCatalog());
        return affliction;
    }
}
