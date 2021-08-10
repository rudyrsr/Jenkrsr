
package com.dh.spring5webapp.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Position")
public class Position extends ModelBase {
    private String positionType;
    private String positionDescription;
    private String positionCode;
    private String name;
    private boolean deleted = false;

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getPositionType() {

        return positionType;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
