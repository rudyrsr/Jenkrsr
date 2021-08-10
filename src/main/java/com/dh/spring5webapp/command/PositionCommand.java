package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.FuntionalManual;
import com.dh.spring5webapp.model.ModelBase;
import com.dh.spring5webapp.model.Position;

public class PositionCommand extends ModelBase {
    private Long id;
    private String positionName;
    private String positionCode;
    private String positionDescription;
    private String positionType;
    private boolean deleted;


    public PositionCommand() {
    }

    public PositionCommand(Position position) {
        this.setId(position.getId());
        this.setPositionCode(position.getPositionCode());
        this.setPositionDescription(position.getPositionDescription());
        this.setPositionName(position.getName());
        this.setPositionType(position.getPositionType());
        this.setCreatedOn(position.getCreatedOn());
        this.setUpdatedOn(position.getUpdatedOn());
        this.setVersion(position.getVersion());
        this.setDeleted(position.isDeleted());
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public String getPositionName() {

        return positionName;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public String getPositionType() {
        return positionType;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Position toPosition()
    {
        Position position = new Position();
        position.setId(getId());
        position.setPositionType(getPositionType());
        position.setPositionDescription(getPositionDescription());
        position.setPositionCode(getPositionCode());
        position.setName(getPositionName());
        position.setCreatedOn(getCreatedOn());
        position.setUpdatedOn(getUpdatedOn());
        return position;
    }


}
