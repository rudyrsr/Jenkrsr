package com.dh.spring5webapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CatalogFI")
public class CatalogFI extends ModelBase{

    @Column(name="catalogFICode")
    private String catalogFICode;
    @Column(name="catalogFIName")
    private String catalogFIName;
    @Column(name="catalogFIDescription")
    private String catalogFIDescription;
    @Column(name = "deleted")
    private boolean deleted=false;

    public CatalogFI() {
    }

    public CatalogFI(String catalogFICode, String catalogFIName, String catalogFIDescription,boolean deleted) {
        this.catalogFICode = catalogFICode;
        this.catalogFIName = catalogFIName;
        this.catalogFIDescription = catalogFIDescription;
        this.deleted=deleted;
    }

    public String getCatalogFIName() {
        return catalogFIName;
    }

    public void setCatalogFIName(String catalogFIName) {
        this.catalogFIName = catalogFIName;
    }

    public String getCatalogFIDescription() {
        return catalogFIDescription;
    }

    public void setCatalogFIDescription(String catalogFIDescription) {
        this.catalogFIDescription = catalogFIDescription;
    }

    public String getCatalogFICode() {
        return catalogFICode;
    }

    public void setCatalogFICode(String catalogFICode) {
        this.catalogFICode = catalogFICode;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
