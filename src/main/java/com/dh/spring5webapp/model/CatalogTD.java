package com.dh.spring5webapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CatalogTD")
public class CatalogTD extends ModelBase  {
    @Column(name="catalogTDCode")
    private String catalogTDCode;
    @Column(name="cataloTDName")
    private String catalogTDName;
    @Column(name="catalogTDDescription")
    private String catalogTDDescription;
    @Column(name = "deleted")
    private boolean deleted=false;

    public CatalogTD() {
    }

    public CatalogTD(String catalogTDCode, String catalogTDName, String catalogTDDescription,boolean deleted) {
        this.catalogTDCode = catalogTDCode;
        this.catalogTDName = catalogTDName;
        this.catalogTDDescription = catalogTDDescription;
        this.deleted=deleted;
    }

    public String getCatalogTDCode() {
        return catalogTDCode;
    }

    public void setCatalogTDCode(String catalogTDCode) {
        this.catalogTDCode = catalogTDCode;
    }

    public String getCatalogTDName() {
        return catalogTDName;
    }

    public void setCatalogTDName(String catalogTDName) {
        this.catalogTDName = catalogTDName;
    }

    public String getCatalogTDDescription() {
        return catalogTDDescription;
    }

    public void setCatalogTDDescription(String catalogTDDescription) {
        this.catalogTDDescription = catalogTDDescription;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
