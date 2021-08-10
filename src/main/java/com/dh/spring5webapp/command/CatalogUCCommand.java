package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.CatalogUA;
import com.dh.spring5webapp.model.CatalogUC;

public class CatalogUCCommand {
    private Long Id;
    private String catalogUCCode;
    private String catalogUCName;
    private String catalogUCDescription;
    private boolean deleted;

    public CatalogUCCommand() {
    }
    public CatalogUCCommand(CatalogUC catalogUC)
    {
        this.setId(catalogUC.getId());
        this.setCatalogUCName(catalogUC.getCatalogUCName());
        this.setCatalogUCDescription(catalogUC.getCatalogUCDescription());
        this.setCatalogUCCode(catalogUC.getCatalogUCCode());
        this.setDeleted(catalogUC.isDeleted());
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

    public CatalogUC toDomain() {
        CatalogUC catalog = new CatalogUC();
        catalog.setId(getId());
        catalog.setCatalogUCCode(getCatalogUCCode());
        catalog.setCatalogUCName(getCatalogUCName());
        catalog.setCatalogUCDescription(getCatalogUCDescription());
        return catalog;
    }
}
