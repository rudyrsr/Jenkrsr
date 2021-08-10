package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.CatalogTD;

public class CatalogTDCommand {
    private Long Id;
    private String catalogTDCode;
    private String catalogTDName;
    private String catalogTDDescription;
    private boolean deleted;

    public CatalogTDCommand() {
    }
    public CatalogTDCommand(CatalogTD catalogTD)
    {
        this.setId(catalogTD.getId());
        this.setCatalogTDName(catalogTD.getCatalogTDName());
        this.setCatalogTDDescription(catalogTD.getCatalogTDDescription());
        this.setCatalogTDCode(catalogTD.getCatalogTDCode());
        this.setDeleted(catalogTD.isDeleted());
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

    public CatalogTD toDomain()
    {
        CatalogTD catalogTD=new CatalogTD();
        catalogTD.setId(getId());
        catalogTD.setCatalogTDCode(getCatalogTDCode());
        catalogTD.setCatalogTDName(getCatalogTDName());
        catalogTD.setCatalogTDDescription(getCatalogTDDescription());
        return catalogTD;
    }
}
