package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.Category;
import com.dh.spring5webapp.model.ModelBase;
import com.dh.spring5webapp.model.SubCategory;

public class SubCategoryCommand extends ModelBase {
    private String nameSub;
    private String codeSub;
    private Long categoryId;
    private Long idSub;
    private Category category;
    private boolean deleted;

    public SubCategoryCommand() {
    }

    public String getNameSub() {
        return nameSub;
    }

    public void setNameSub(String nameSub) {
        this.nameSub = nameSub;
    }

    public String getCodeSub() {
        return codeSub;
    }

    public void setCodeSub(String codeSub) {
        this.codeSub = codeSub;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getIdSub() {
        return idSub;
    }

    public void setIdSub(Long idSub) {
        this.idSub = idSub;
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

    public SubCategoryCommand(SubCategory subCategory) {
        this.setCodeSub(subCategory.getCode());
        this.setNameSub(subCategory.getName());
        this.setIdSub(subCategory.getId());
        this.setVersion(subCategory.getVersion());
        this.setCreatedOn(subCategory.getCreatedOn());
        this.setUpdatedOn(subCategory.getUpdatedOn());
        this.setCategoryId(subCategory.getCategory().getId());
        this.setDeleted(subCategory.isDeleted());
        //aniado mi command para mostrar en object json
        /*CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setCode(subCategory.getCategory().getCode());
        categoryCommand.setNameCategory(subCategory.getCategory().getName());
        categoryCommand.setIdCateg(subCategory.getCategory().getId());
        categoryCommand.setVersion(subCategory.getCategory().getVersion());
        categoryCommand.setUpdatedOn(subCategory.getCategory().getUpdatedOn());
        categoryCommand.setCreatedOn(subCategory.getCategory().getCreatedOn());
        category = new Category(categoryCommand);
        this.setCategory(category);*/
    }

    public SubCategory toSubCategory() {
        SubCategory subCategory = new SubCategory();
        subCategory.setCode(getCodeSub());
        subCategory.setName(getNameSub());
        subCategory.setId(getIdSub());
        subCategory.setCategory(getCategory());
        return subCategory;
    }
}
