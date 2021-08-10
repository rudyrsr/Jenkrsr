
package com.dh.spring5webapp.model;

import com.dh.spring5webapp.command.ItemCommand;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Item")
public class Item extends ModelBase {
    private String name;
    private String code;
    @Lob
    private Byte[] image;

    // targetEntity especifica el dueño de la relacion
    @OneToOne(targetEntity = SubCategory.class)
    private SubCategory subCategory;
    //aniadiendo dos atributos mas segun la base de datos
    private String description;
    private String state;
    //porque en el itemcommand esta con string y el long no es int para mandar dato
    private String price;
    private String label;
    private boolean deleted;
    //para el relacionamiento de tabla
    @OneToMany(mappedBy = "item", orphanRemoval = true, fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    private Set<ItemAsignation> listItemAsignation = new HashSet<>();

    public Item() {
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

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Set<ItemAsignation> getListItemAsignation() {
        return listItemAsignation;
    }

    public void setListItemAsignation(Set<ItemAsignation> listItemAsignation) {
        this.listItemAsignation = listItemAsignation;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Item(ItemCommand itemCommand) {
        this.setName(itemCommand.getName());
        this.setCode(itemCommand.getCode());
        this.setDescription(itemCommand.getDescription());
        this.setState(itemCommand.getState());
        this.setPrice(itemCommand.getPrice());
        this.setId(itemCommand.getId());
        this.setCreatedOn(itemCommand.getCreatedOn());
        this.setUpdatedOn(itemCommand.getUpdatedOn());
        this.setVersion(itemCommand.getVersion());
        this.setLabel(itemCommand.getLabel());

    }
}
