package com.dh.spring5webapp.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Affliction_Catalog")
public class AfflictionCatalog extends ModelBase {

    private String name;
    private String code;
    private String description;
    private boolean deleted;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
