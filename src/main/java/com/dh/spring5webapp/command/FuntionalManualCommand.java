package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.FuntionalManual;
import com.dh.spring5webapp.model.ModelBase;
import com.dh.spring5webapp.model.Position;

import java.util.Date;

public class FuntionalManualCommand extends ModelBase {
    private Long id;
    private String functionalmanualCode;
    private Date functionalmanualDate;
    private String functionalmanualName;
    private String functionalmanualDescription;
    private String functionalmanualUrl;
    private String OrganitationalLevel;
    private String EducationLevel;
    private boolean deleted;
    private Long positionId;

    private PositionCommand positionCommand;

    public FuntionalManualCommand() {
    }

    public FuntionalManualCommand(FuntionalManual funtionalManual) {
        this.setId(funtionalManual.getId());
        this.setFunctionalmanualCode(funtionalManual.getCode());
        this.setFunctionalmanualDate(funtionalManual.getDate());
        this.setFunctionalmanualName(funtionalManual.getName());
        this.setFunctionalmanualDescription(funtionalManual.getDescription());
        this.setFunctionalmanualUrl(funtionalManual.getUrl());
        this.setCreatedOn(funtionalManual.getCreatedOn());
        this.setUpdatedOn(funtionalManual.getUpdatedOn());
        this.setVersion(funtionalManual.getVersion());
        this.setDeleted(funtionalManual.isDeleted());
        this.setPositionCommand(new PositionCommand(funtionalManual.getPosition()));
        this.setPositionId(funtionalManual.getPositionid());
        this.setOrganitationalLevel(funtionalManual.getOrganitationalLevel());
        this.setEducationLevel(funtionalManual.getEducationLevel());
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getFunctionalmanualCode() {
        return functionalmanualCode;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setFunctionalmanualCode(String functionalmanualCode) {
        this.functionalmanualCode = functionalmanualCode;
    }

    public Date getFunctionalmanualDate() {
        return functionalmanualDate;
    }

    public void setFunctionalmanualDate(Date functionalmanualDate) {
        this.functionalmanualDate = functionalmanualDate;
    }

    public String getFunctionalmanualName() {
        return functionalmanualName;
    }

    public void setFunctionalmanualName(String functionalmanualName) {
        this.functionalmanualName = functionalmanualName;
    }

    public String getFunctionalmanualDescription() {
        return functionalmanualDescription;
    }

    public void setFunctionalmanualDescription(String functionalmanualDescription) {
        this.functionalmanualDescription = functionalmanualDescription;
    }

    public String getFunctionalmanualUrl() {
        return functionalmanualUrl;
    }

    public void setFunctionalmanualUrl(String functionalmanualUrl) {
        this.functionalmanualUrl = functionalmanualUrl;
    }

    public PositionCommand getPositionCommand() {
        return positionCommand;
    }

    public void setPositionCommand(PositionCommand positionCommand) {
        this.positionCommand = positionCommand;
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

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public FuntionalManual toDomain() {
        FuntionalManual funtionalManual = new FuntionalManual();
        funtionalManual.setCode(getFunctionalmanualCode());
        funtionalManual.setName(getFunctionalmanualName());
        funtionalManual.setDescription(getFunctionalmanualDescription());
        funtionalManual.setDate(getFunctionalmanualDate());
        funtionalManual.setUrl(getFunctionalmanualUrl());
        funtionalManual.setPositionid(getPositionId());
        funtionalManual.setEducationLevel(getEducationLevel());
        funtionalManual.setOrganitationalLevel(getOrganitationalLevel());
        return funtionalManual;
    }
}
