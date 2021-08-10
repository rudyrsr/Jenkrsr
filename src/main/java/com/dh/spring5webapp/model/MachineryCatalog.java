package com.dh.spring5webapp.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Machinery_Catalog")
public class MachineryCatalog extends ModelBase {
    private String name;
    private String cod;
    private String characteristics;
    private Byte[] image;
    private String description;
    private boolean deleted = false;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}