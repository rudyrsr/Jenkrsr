package com.dh.spring5webapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CatalogUA")
public class CatalogUA extends ModelBase {
    @Column(name = "catalogUACode")
    private String catalogUACode;
    @Column(name = "cataloUAName")
    private String catalogUAName;
    @Column(name = "catalogUADescription")
    private String catalogUADescription;
    @Column(name = "deleted")
    private boolean deleted=false;

    public CatalogUA() {
    }

    public CatalogUA(String catalogUACode, String catalogUAName, String catalogUADescription,boolean deleted) {
        this.catalogUACode = catalogUACode;
        this.catalogUAName = catalogUAName;
        this.catalogUADescription = catalogUADescription;
        this.deleted=deleted;
    }

    public String getCatalogUACode() {
        return catalogUACode;
    }

    public void setCatalogUACode(String catalogUACode) {
        this.catalogUACode = catalogUACode;
    }

    public String getCatalogUAName() {
        return catalogUAName;
    }

    public void setCatalogUAName(String catalogUAName) {
        this.catalogUAName = catalogUAName;
    }

    public String getCatalogUADescription() {
        return catalogUADescription;
    }

    public void setCatalogUADescription(String catalogUADescription) {
        this.catalogUADescription = catalogUADescription;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}