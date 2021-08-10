package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.CatalogFI;

public class CatalogFICommand {
    private Long Id;
    private String catalogFICode;
    private String catalogFIName;
    private String catalogFIDescription;
    private boolean deleted;
    public CatalogFICommand() {
    }
    public CatalogFICommand(CatalogFI catalogFI)
    {
        this.setId(catalogFI.getId());
        this.setCatalogFIName(catalogFI.getCatalogFIName());
        this.setCatalogFIDescription(catalogFI.getCatalogFIDescription());
        this.setCatalogFICode(catalogFI.getCatalogFICode());
        this.setDeleted(catalogFI.isDeleted());
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getCatalogFICode() {
        return catalogFICode;
    }

    public void setCatalogFICode(String catalogFICode) {
        this.catalogFICode = catalogFICode;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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
    public CatalogFI toDomain()
    {
        CatalogFI catalogFI=new CatalogFI();
        catalogFI.setId(getId());
        catalogFI.setCatalogFICode(getCatalogFICode());
        catalogFI.setCatalogFIName(getCatalogFIName());
        catalogFI.setCatalogFIDescription(getCatalogFIDescription());
        return catalogFI;
    }
}
