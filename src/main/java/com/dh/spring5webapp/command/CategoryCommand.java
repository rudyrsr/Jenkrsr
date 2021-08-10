package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.Category;
import com.dh.spring5webapp.model.ModelBase;

public class CategoryCommand extends ModelBase {
    //atributos del objeto category
    private String nameCategory;
    private String code;
    private Long idCateg;
    private boolean deleted;

    public CategoryCommand() {
    }

    public CategoryCommand(Category category) {
        this.setIdCateg(category.getId());
        this.setNameCategory(category.getName());
        this.setCode(category.getCode());
        this.setUpdatedOn(category.getUpdatedOn());
        this.setCreatedOn(category.getCreatedOn());
        this.setVersion(category.getVersion());
        this.setDeleted(category.isDeleted());
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getIdCateg() {
        return idCateg;
    }

    public void setIdCateg(Long idCateg) {
        this.idCateg = idCateg;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Category toCategory() {
        Category category = new Category();
        category.setName(getNameCategory());
        category.setCode(getCode());
        category.setId(getIdCateg());
        return category;
    }
}
