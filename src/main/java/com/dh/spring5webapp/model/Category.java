
package com.dh.spring5webapp.model;

import com.dh.spring5webapp.command.CategoryCommand;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category extends ModelBase {
    private String name;
    private String code;
    private boolean deleted;
    public Category() {
    }

    public Category(CategoryCommand catcom) {
        this.setId(catcom.getIdCateg());
        this.setName(catcom.getNameCategory());
        this.setCode(catcom.getCode());
        this.setUpdatedOn(catcom.getUpdatedOn());
        this.setCreatedOn(catcom.getCreatedOn());
        this.setVersion(catcom.getVersion());
    }
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
