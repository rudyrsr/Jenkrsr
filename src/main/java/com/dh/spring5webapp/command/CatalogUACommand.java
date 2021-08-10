package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.CatalogUA;

public class CatalogUACommand {
    private Long Id;
    private String catalogUACode;
    private String catalogUAName;
    private String catalogUADescription;
    private boolean deleted;


    public CatalogUACommand() {
    }
    public CatalogUACommand(CatalogUA catalogUA)
    {
        this.setId(catalogUA.getId());
        this.setCatalogUAName(catalogUA.getCatalogUAName());
        this.setCatalogUADescription(catalogUA.getCatalogUADescription());
        this.setCatalogUACode(catalogUA.getCatalogUACode());
        this.setDeleted(catalogUA.isDeleted());
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

    public CatalogUA toDomain() {
        CatalogUA catalog = new CatalogUA();
        catalog.setId(getId());
        catalog.setCatalogUACode(getCatalogUACode());
        catalog.setCatalogUAName(getCatalogUAName());
        catalog.setCatalogUADescription(getCatalogUADescription());
        return catalog;
    }
}
