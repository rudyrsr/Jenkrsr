/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.Category;
import com.dh.spring5webapp.model.Item;
import com.dh.spring5webapp.model.ModelBase;
import com.dh.spring5webapp.model.SubCategory;
import org.apache.tomcat.util.codec.binary.Base64;

public class ItemCommand extends ModelBase {

    private String name;
    private String code;
    private String label;
    private String image;
    private String category;
    private Long subCategoryId;
    private String price;
    private Object[] comments = new Object[0];
    private Long id;
    private String description;
    private Boolean featured;
    //aniado el atributo state para el estado de item
    private String state;
    private SubCategory subCategory;

    //para mostrar informacion al exterior
    public ItemCommand(Item item) {
        this.setCategory(item.getSubCategory().getCategory().getName());
        this.setSubCategoryId(item.getSubCategory().getId());
        this.setDescription(item.getDescription());
        this.setFeatured(item.isDeleted());
        this.setId(item.getId());
        this.setName(item.getName());
        this.setLabel(item.getLabel());
        this.setCode(item.getCode());
        if (item.getImage() != null) {
            byte[] bytes = new byte[item.getImage().length];
            for (int i = 0; i < item.getImage().length; i++) {
                bytes[i] = item.getImage()[i];
            }
            String imageStr = Base64.encodeBase64String(bytes);
            this.setImage(imageStr);
        }
        this.setPrice(item.getPrice());
        //aniado el valor de state para mostrar por postman
        this.setState(item.getState());
        this.setVersion(item.getVersion());
        this.setCreatedOn(item.getCreatedOn());
        this.setUpdatedOn(item.getUpdatedOn());

        //me creo comandos para mostrar por objects json
        /*SubCategoryCommand sc = new SubCategoryCommand();
        sc.setCodeSub(item.getSubCategory().getCode());
        sc.setNameSub(item.getSubCategory().getName());
        sc.setIdSub(item.getSubCategory().getId());
        sc.setUpdatedOn(item.getSubCategory().getUpdatedOn());
        sc.setCreatedOn(item.getSubCategory().getCreatedOn());
        sc.setVersion(item.getSubCategory().getVersion());
        subCategory = new SubCategory(sc);
        this.setSubCategory(subCategory);
*/
        /*CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setCode(item.getSubCategory().getCategory().getCode());
        categoryCommand.setNameCategory(item.getSubCategory().getCategory().getName());
        categoryCommand.setIdCateg(item.getSubCategory().getCategory().getId());
        categoryCommand.setCreatedOn(item.getSubCategory().getCategory().getCreatedOn());
        categoryCommand.setUpdatedOn(item.getSubCategory().getCategory().getUpdatedOn());
        categoryCommand.setVersion(item.getSubCategory().getCategory().getVersion());
        Category categ1 = new Category(categoryCommand);
        subCategory.setCategory(categ1);*/

    }

    public ItemCommand() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Object[] getComments() {
        return comments;
    }

    public void setComments(Object[] comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    //para guardar al interior en la base de datos
    public Item toDomain() {
        Item item = new Item();
        item.setCode(getCode());
        item.setId(getId());
        item.setName(getName());
        //aniado los otros seters de mi modelo de bd
        item.setDescription(getDescription());
        //del nuevo atributo aniadido
        item.setState(getState());
        item.setPrice(getPrice());
        item.setLabel(getLabel());
        //cambiando mi subcategory (solo eso porque category es de subcategory y debe cambiarse en subcategory)
        item.setSubCategory(getSubCategory());
        return item;
    }
}
