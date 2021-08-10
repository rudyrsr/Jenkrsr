package com.dh.spring5webapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CatalogUC")
public class CatalogUC extends ModelBase {
    @Column(name = "catalogUCCode")
    private String catalogUCCode;
    @Column(name = "cataloUCName")
    private String catalogUCName;
    @Column(name = "catalogUCDescription")
    private String catalogUCDescription;
    @Column(name = "deleted")
    private boolean deleted=false;

    public CatalogUC() {
    }

    public CatalogUC(String catalogUCCode, String catalogUCName, String catalogUCDescription,boolean deleted) {
        this.catalogUCCode = catalogUCCode;
        this.catalogUCName = catalogUCName;
        this.catalogUCDescription = catalogUCDescription;
        this.deleted=deleted;
    }

    public String getCatalogUCCode() {
        return catalogUCCode;
    }

    public void setCatalogUCCode(String catalogUCCode) {
        this.catalogUCCode = catalogUCCode;
    }

    public String getCatalogUCName() {
        return catalogUCName;
    }

    public void setCatalogUCName(String catalogUCName) {
        this.catalogUCName = catalogUCName;
    }

    public String getCatalogUCDescription() {
        return catalogUCDescription;
    }

    public void setCatalogUCDescription(String catalogUCDescription) {
        this.catalogUCDescription = catalogUCDescription;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}