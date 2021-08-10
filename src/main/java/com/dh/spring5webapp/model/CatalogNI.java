package com.dh.spring5webapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CatalogNI")
public class CatalogNI extends ModelBase  {
    @Column(name="catalogNICode")
    private String catalogNICode;
    @Column(name="catalogNIName")
    private String catalogNIName;
    @Column(name="catalogNIDescription")
    private String catalogNIDescription;
    @Column(name = "deleted")
    private boolean deleted=false;

    public CatalogNI() {
    }

    public CatalogNI(String catalogNICode, String catalogNIName, String catalogNIDescription,boolean deleted) {
        this.catalogNICode = catalogNICode;
        this.catalogNIName = catalogNIName;
        this.catalogNIDescription = catalogNIDescription;
        this.deleted=deleted;
    }

    public String getCatalogNICode() {
        return catalogNICode;
    }

    public void setCatalogNICode(String catalogNICode) {
        this.catalogNICode = catalogNICode;
    }

    public String getCatalogNIName() {
        return catalogNIName;
    }

    public void setCatalogNIName(String catalogNIName) {
        this.catalogNIName = catalogNIName;
    }

    public String getCatalogNIDescription() {
        return catalogNIDescription;
    }

    public void setCatalogNIDescription(String catalogNIDescription) {
        this.catalogNIDescription = catalogNIDescription;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
