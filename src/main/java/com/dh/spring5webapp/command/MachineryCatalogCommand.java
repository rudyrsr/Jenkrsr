package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.MachineryCatalog;
import com.dh.spring5webapp.model.ModelBase;
import org.apache.tomcat.util.codec.binary.Base64;

public class MachineryCatalogCommand extends ModelBase {
    private Long id;
    private String machinerycatalogName;
    private String machinerycatalogCod;
    private String characteristics;
    private String image;
    private String machinerycatalogDescription;
    private String machinerycatalogLabel;
    private boolean deleted;



    public MachineryCatalogCommand(MachineryCatalog machineryCatalog) {
        this.setId(machineryCatalog.getId());
        this.setMachinerycatalogName(machineryCatalog.getName());
        this.setMachinerycatalogCod(machineryCatalog.getCod());
        this.setCharacteristics(machineryCatalog.getCharacteristics());
        this.setCreatedOn(machineryCatalog.getCreatedOn());
        this.setUpdatedOn(machineryCatalog.getUpdatedOn());
        this.setVersion(machineryCatalog.getVersion());
        this.setMachinerycatalogDescription(machineryCatalog.getDescription());
        this.setDeleted(machineryCatalog.isDeleted());

        if (machineryCatalog.getImage() != null) {
            byte[] bytes = new byte[machineryCatalog.getImage().length];
            for (int i = 0; i < machineryCatalog.getImage().length; i++) {
                bytes[i] = machineryCatalog.getImage()[i];
            }
            String imageStr = Base64.encodeBase64String(bytes);
            this.setImage(imageStr);
        }

    }


    public MachineryCatalogCommand() {
    }

    public String getMachinerycatalogName() {
        return machinerycatalogName;
    }

    public void setMachinerycatalogName(String machinerycatalogName) {
        this.machinerycatalogName = machinerycatalogName;
    }

    public String getMachinerycatalogCod() {
        return machinerycatalogCod;
    }

    public void setMachinerycatalogCod(String machinerycatalogCod) {
        this.machinerycatalogCod = machinerycatalogCod;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMachinerycatalogDescription() {
        return machinerycatalogDescription;
    }

    public void setMachinerycatalogDescription(String machinerycatalogDescription) {
        this.machinerycatalogDescription = machinerycatalogDescription;
    }

    public String getMachinerycatalogLabel() {
        return machinerycatalogLabel = getMachinerycatalogCod() + "-" + getId();
    }

    public void setMachinerycatalogLabel(String machinerycatalogLabel) {
        this.machinerycatalogLabel = machinerycatalogLabel;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public MachineryCatalog toDomain() {
        MachineryCatalog machineryCatalog = new MachineryCatalog();
        machineryCatalog.setName(getMachinerycatalogName());
        machineryCatalog.setCharacteristics(getCharacteristics());
        machineryCatalog.setCod(getMachinerycatalogCod());
        machineryCatalog.setId(getId());
        machineryCatalog.setDescription(getMachinerycatalogDescription());

        return machineryCatalog;
    }

}
