package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.CatalogNI;

public class CatalogNICommand {
    private Long Id;
    private String catalogNICode;
    private String catalogNIName;
    private String catalogNIDescription;
    private boolean deleted;

    public CatalogNICommand() {
    }
    public CatalogNICommand(CatalogNI catalogNI)
    {
        this.setId(catalogNI.getId());
        this.setCatalogNIName(catalogNI.getCatalogNIName());
        this.setCatalogNIDescription(catalogNI.getCatalogNIDescription());
        this.setCatalogNICode(catalogNI.getCatalogNICode());
        this.setDeleted(catalogNI.isDeleted());
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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
    public CatalogNI toDomain()
    {
        CatalogNI catalogNI=new CatalogNI();
        catalogNI.setId(getId());
        catalogNI.setCatalogNICode(getCatalogNICode());
        catalogNI.setCatalogNIName(getCatalogNIName());
        catalogNI.setCatalogNIDescription(getCatalogNIDescription());
        return catalogNI;
    }
}
