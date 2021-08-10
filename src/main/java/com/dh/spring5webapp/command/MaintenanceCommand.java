package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.Machinery;
import com.dh.spring5webapp.model.Maintenance;
import com.dh.spring5webapp.model.ModelBase;

import java.util.Date;

public class MaintenanceCommand extends ModelBase {
    private Long id;
    private String maintenanceLabel;
    private String maintenanceCode;
    private String maintenanceDescription;
    private String maintenanceObservation;
    private Double maintenancePrice;
    private Long machineryId;
    private Date maintenanceTimeLineInitDate;
    private Date maintenanceTimeLineEndDate;
    private Maintenance maintenance;

    private boolean deleted;


    private MachineryCommand machineryCMD;

    public MaintenanceCommand() {

    }

    public MaintenanceCommand(Maintenance maintenance) {
        this.setMaintenanceCode(maintenance.getCode());
        this.setMaintenanceDescription(maintenance.getDescription());
        this.setMaintenanceObservation(maintenance.getObservation());
        this.setMaintenancePrice(maintenance.getPrice());
        this.setMachineryId(maintenance.getMachinery().getId());
        this.setId(maintenance.getId());
        this.setMaintenanceTimeLineInitDate(maintenance.getTimelineinitdate());
        this.setMaintenanceTimeLineEndDate(maintenance.getTimelineenddate());
        this.setUpdatedOn(maintenance.getUpdatedOn());
        this.setCreatedOn(maintenance.getCreatedOn());
        this.setVersion(maintenance.getVersion());
        this.setDeleted(maintenance.isDeleted());


        this.setMachineryCMD(new MachineryCommand(maintenance.getMachinery()));

    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public MaintenanceCommand(Machinery machinery) {
        super();
    }

    public MaintenanceCommand(Long maintenanceid) {
        super();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaintenanceCode() {
        return maintenanceCode;
    }

    public void setMaintenanceCode(String maintenanceCode) {
        this.maintenanceCode = maintenanceCode;
    }

    public String getMaintenanceDescription() {
        return maintenanceDescription;
    }

    public void setMaintenanceDescription(String maintenanceDescription) {
        this.maintenanceDescription = maintenanceDescription;
    }

    public String getMaintenanceObservation() {
        return maintenanceObservation;
    }

    public void setMaintenanceObservation(String maintenanceObservation) {
        this.maintenanceObservation = maintenanceObservation;
    }

    public Double getMaintenancePrice() {
        return maintenancePrice;
    }

    public void setMaintenancePrice(Double maintenancePrice) {
        this.maintenancePrice = maintenancePrice;
    }

    public Long getMachineryId() {
        return machineryId;
    }

    public void setMachineryId(Long machineryId) {
        this.machineryId = machineryId;
    }

    public Date getMaintenanceTimeLineInitDate() {
        return maintenanceTimeLineInitDate;
    }

    public void setMaintenanceTimeLineInitDate(Date maintenanceTimeLineInitDate) {
        this.maintenanceTimeLineInitDate = maintenanceTimeLineInitDate;
    }

    public Date getMaintenanceTimeLineEndDate() {
        return maintenanceTimeLineEndDate;
    }

    public void setMaintenanceTimeLineEndDate(Date maintenanceTimeLineEndDate) {
        this.maintenanceTimeLineEndDate = maintenanceTimeLineEndDate;
    }

    public MachineryCommand getMachineryCMD() {
        return machineryCMD;
    }

    public void setMachineryCMD(MachineryCommand machineryCMD) {
        this.machineryCMD = machineryCMD;
    }

    public Maintenance getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(Maintenance maintenance) {
        this.maintenance = maintenance;
    }

    public String getMaintenanceLabel() {
        return maintenanceLabel = getMaintenanceCode() + "-" + getId();
    }

    public void setMaintenanceLabel(String maintenanceLabel) {
        this.maintenanceLabel = maintenanceLabel;
    }

    public Maintenance toDomain() {
        Maintenance maintenance = new Maintenance();
        maintenance.setCode(getMaintenanceCode());
        maintenance.setDescription(getMaintenanceDescription());
        maintenance.setObservation(getMaintenanceObservation());
        maintenance.setPrice(getMaintenancePrice());
        maintenance.setMachineryid(getMachineryId());
        maintenance.setTimelineinitdate(getMaintenanceTimeLineInitDate());
        maintenance.setTimelineenddate(getMaintenanceTimeLineEndDate());
        return maintenance;
    }
}
