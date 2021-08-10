/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.dh.spring5webapp.model;

import com.dh.spring5webapp.command.SubCategoryCommand;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Sub_Category")

public class SubCategory extends ModelBase {
    private String name;
    private String code;
    //especifica el duenio de la relacion
    @OneToOne(targetEntity = Category.class)
    private Category category;
    private boolean deleted;
    public SubCategory() {
    }

    public SubCategory(SubCategoryCommand subcomm) {
        this.setName(subcomm.getNameSub());
        this.setCode(subcomm.getCodeSub());
        this.setId(subcomm.getIdSub());
        this.setCategory(subcomm.getCategory());
        this.setCreatedOn(subcomm.getCreatedOn());
        this.setUpdatedOn(subcomm.getUpdatedOn());
        this.setVersion(subcomm.getVersion());
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
