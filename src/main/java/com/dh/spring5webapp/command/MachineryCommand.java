package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.Machinery;
import com.dh.spring5webapp.model.Maintenance;
import com.dh.spring5webapp.model.ModelBase;
import org.apache.tomcat.util.codec.binary.Base64;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MachineryCommand extends ModelBase {

    private Long id;
    private String machineryLabel;
    private String machineryCode;
    private String machineryName;
    private Date machineryDateBuy;
    private Integer machineryAvailable;
    private Double machineryPrice;
    private String machineryBrand;
    private String image;
    private Long machineryCatalogId;
    private boolean deleted;



    private Set<MaintenanceCommand> maintenancesCMList = new HashSet<>();
    //private MaintenanceCommand maintenancesCMList;

    public MachineryCommand() {
    }

    public MachineryCommand(Machinery machinery) {
        this.setId(machinery.getId());
        this.setMachineryLabel(machinery.getCode());
        this.setMachineryCode(machinery.getCode());
        this.setMachineryName(machinery.getName());
        this.setMachineryDateBuy(machinery.getDateBuy());
        this.setMachineryAvailable(machinery.getAvailable());
        this.setMachineryPrice(machinery.getPrice());
        this.setCreatedOn(machinery.getCreatedOn());
        this.setMachineryCatalogId(machinery.getMachineryCatalog().getId());
        this.setUpdatedOn(machinery.getUpdatedOn());
        this.setCreatedOn(machinery.getCreatedOn());
        this.setVersion(machinery.getVersion());
        this.setDeleted(machinery.isDeleted());

        //this.setMaintenancesCMList(new MaintenanceCommand(toDomain()));


        machinery.getMaintenanceList().forEach(
                maintenance -> this.maintenancesCMList.add(new MaintenanceCommand(machinery)));


        if (machinery.getImage() != null) {
            byte[] bytes = new byte[machinery.getImage().length];
            for (int i = 0; i < machinery.getImage().length; i++) {
                bytes[i] = machinery.getImage()[i];
            }
            String imageStr = Base64.encodeBase64String(bytes);
            this.setImage(imageStr);
        }
        this.setMachineryBrand(machinery.getBrand());
    }

    public MachineryCommand(Maintenance maintenance) {

    }

    /*public MaintenanceCommand getMaintenancesCMList() {
        return maintenancesCMList;
    }

    public void setMaintenancesCMList(MaintenanceCommand maintenancesCMList) {
        this.maintenancesCMList = maintenancesCMList;
    }
*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMachineryLabel() {
        return machineryLabel = getMachineryCode() + "-" + getId();
    }

    public void setMachineryLabel(String machineryLabel) {
        this.machineryLabel = machineryLabel;
    }

    public String getMachineryCode() {
        return machineryCode;
    }

    public void setMachineryCode(String machineryCode) {
        this.machineryCode = machineryCode;
    }

    public String getMachineryName() {
        return machineryName;
    }

    public void setMachineryName(String machineryName) {
        this.machineryName = machineryName;
    }

    public Date getMachineryDateBuy() {
        return machineryDateBuy;
    }

    public void setMachineryDateBuy(Date machineryDateBuy) {
        this.machineryDateBuy = machineryDateBuy;
    }

    public Integer getMachineryAvailable() {
        return machineryAvailable;
    }

    public void setMachineryAvailable(Integer machineryAvailable) {
        this.machineryAvailable = machineryAvailable;
    }

    public Double getMachineryPrice() {
        return machineryPrice;
    }

    public void setMachineryPrice(Double machineryPrice) {
        this.machineryPrice = machineryPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMachineryBrand() {
        return machineryBrand;
    }

    public void setMachineryBrand(String machineryBrand) {
        this.machineryBrand = machineryBrand;
    }

    public Long getMachineryCatalogId() {
        return machineryCatalogId;
    }

    public void setMachineryCatalogId(Long machineryCatalogId) {
        this.machineryCatalogId = machineryCatalogId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Machinery toDomain() {
        Machinery machinery = new Machinery();
        machinery.setCode(getMachineryCode());
        machinery.setId(getId());
        machinery.setName(getMachineryName());
        machinery.setAvailable(getMachineryAvailable());
        machinery.setBrand(getMachineryBrand());
        machinery.setPrice(getMachineryPrice());
        machinery.setDateBuy(getMachineryDateBuy());

        return machinery;
    }
}
