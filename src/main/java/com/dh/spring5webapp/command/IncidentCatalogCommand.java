
package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.IncidentCatalog;
import com.dh.spring5webapp.model.ModelBase;


public class IncidentCatalogCommand extends ModelBase {

    private String incidenCatalogName;
    private String incidentCatalogCode;
    private String insidentCatalogDescription;
    private String incidentCatalogLabel;
    private boolean deleted;

    public IncidentCatalogCommand(IncidentCatalog incidentCatalog) {

        this.setId(incidentCatalog.getId());
        this.setIncidenCatalogName(incidentCatalog.getName());
        this.setIncidentCatalogCode(incidentCatalog.getCode());
        this.setInsidentCatalogDescription(incidentCatalog.getDescription());
        this.setIncidentCatalogLabel(getIncidentCatalogCode());
        this.setCreatedOn(incidentCatalog.getCreatedOn());
        this.setUpdatedOn(incidentCatalog.getUpdatedOn());
        this.setVersion(incidentCatalog.getVersion());
        this.setDeleted(incidentCatalog.isDeleted());
    }

    public IncidentCatalogCommand() {
    }

    public String getIncidenCatalogName() {
        return incidenCatalogName;
    }

    public void setIncidenCatalogName(String incidenCatalogName) {
        this.incidenCatalogName = incidenCatalogName;
    }

    public String getIncidentCatalogCode() {
        return incidentCatalogCode;
    }

    public void setIncidentCatalogCode(String incidentCatalogCode) {
        this.incidentCatalogCode = incidentCatalogCode;
    }

    public String getInsidentCatalogDescription() {
        return insidentCatalogDescription;
    }

    public void setInsidentCatalogDescription(String insidentCatalogDescription) {
        this.insidentCatalogDescription = insidentCatalogDescription;
    }

    public String getIncidentCatalogLabel() {
        return incidentCatalogLabel;
    }

    public void setIncidentCatalogLabel(String incidentCatalogLabel) {
        this.incidentCatalogLabel = getIncidentCatalogCode() + "-" + getId();
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public IncidentCatalog toDomain() {
        IncidentCatalog incidentCatalog = new IncidentCatalog();
        incidentCatalog.setName(getIncidenCatalogName());
        incidentCatalog.setCode(getIncidentCatalogCode());
        incidentCatalog.setDescription(getInsidentCatalogDescription());
        incidentCatalog.setCreatedOn(getCreatedOn());
        incidentCatalog.setUpdatedOn(getUpdatedOn());
        incidentCatalog.setVersion(getVersion());
        incidentCatalog.setId(getId());
        return incidentCatalog;
    }
}
