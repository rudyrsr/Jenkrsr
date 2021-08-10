
package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.AfflictionCatalog;
import com.dh.spring5webapp.model.ModelBase;


public class AfflictionCatalogCommand extends ModelBase {

    private String afflictionCatalogName;
    private String afflictionCatalogCode;
    private String afflictionCatalogDescription;
    private String afflictionCatalogLabel;
    private boolean deleted;

    public AfflictionCatalogCommand(AfflictionCatalog afflictionCatalog) {

        this.setId(afflictionCatalog.getId());
        this.setAfflictionCatalogName(afflictionCatalog.getName());
        this.setAfflictionCatalogCode(afflictionCatalog.getCode());
        this.setAfflictionCatalogDescription(afflictionCatalog.getDescription());
        this.setAfflictionCatalogLabel(getAfflictionCatalogLabel());
        this.setCreatedOn(afflictionCatalog.getCreatedOn());
        this.setUpdatedOn(afflictionCatalog.getUpdatedOn());
        this.setVersion(afflictionCatalog.getVersion());
        this.setDeleted(afflictionCatalog.isDeleted());
    }

    public AfflictionCatalogCommand() {
    }

    public String getAfflictionCatalogName() {
        return afflictionCatalogName;
    }

    public void setAfflictionCatalogName(String afflictionCatalogName) {
        this.afflictionCatalogName = afflictionCatalogName;
    }

    public String getAfflictionCatalogCode() {
        return afflictionCatalogCode;
    }

    public void setAfflictionCatalogCode(String afflictionCatalogCode) {
        this.afflictionCatalogCode = afflictionCatalogCode;
    }

    public String getAfflictionCatalogDescription() {
        return afflictionCatalogDescription;
    }

    public void setAfflictionCatalogDescription(String afflictionCatalogDescription) {
        this.afflictionCatalogDescription = afflictionCatalogDescription;
    }

    public String getAfflictionCatalogLabel() {
        return afflictionCatalogLabel;
    }

    public void setAfflictionCatalogLabel(String afflictionCatalogLabel) {
        this.afflictionCatalogLabel = getAfflictionCatalogCode() + "-" + getId();
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public AfflictionCatalog toDomain() {
        AfflictionCatalog afflictionCatalog = new AfflictionCatalog();
        afflictionCatalog.setName(getAfflictionCatalogName());
        afflictionCatalog.setCode(getAfflictionCatalogCode());
        afflictionCatalog.setDescription(getAfflictionCatalogDescription());
        afflictionCatalog.setCreatedOn(getCreatedOn());
        afflictionCatalog.setUpdatedOn(getUpdatedOn());
        afflictionCatalog.setVersion(getVersion());
        afflictionCatalog.setId(getId());
        return afflictionCatalog;
    }
}
