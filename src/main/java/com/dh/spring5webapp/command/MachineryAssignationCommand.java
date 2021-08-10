package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.MachineryAssignation;
import com.dh.spring5webapp.model.ModelBase;

import java.util.Date;

public class MachineryAssignationCommand extends ModelBase {
    private Date assignationInitDate;
    private Date assignationEndDate;
    private Long employeeId;
    private Long machineryId;
    private MachineryCommand machineryCM;
    private EmployeeCommand employeeCE;
    private boolean deleted;


    public MachineryAssignationCommand(MachineryAssignation machineryAssignation) {
        this.setId(machineryAssignation.getId());
        this.setAssignationInitDate(machineryAssignation.getAsignationInitDate());
        this.setAssignationEndDate(machineryAssignation.getAsingationEndDate());
        this.setEmployeeId(machineryAssignation.getEmployee().getId());
        this.setMachineryId(machineryAssignation.getMachinery().getId());
        this.setCreatedOn(machineryAssignation.getCreatedOn());
        this.setUpdatedOn(machineryAssignation.getUpdatedOn());
        this.setMachineryCM(new MachineryCommand(machineryAssignation.getMachinery()));
        this.setEmployeeCE(new EmployeeCommand(machineryAssignation.getEmployee()));
        this.setDeleted(machineryAssignation.isDeleted());

    }

    public MachineryAssignationCommand() {
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }


    public MachineryCommand getMachineryCM() {
        return machineryCM;
    }

    public void setMachineryCM(MachineryCommand machineryCM) {
        this.machineryCM = machineryCM;
    }

    public EmployeeCommand getEmployeeCE() {
        return employeeCE;
    }

    public void setEmployeeCE(EmployeeCommand employeeCE) {
        this.employeeCE = employeeCE;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setMachineryId(Long machineryId) {
        this.machineryId = machineryId;
    }

    public Long getEmployeeId() {

        return employeeId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Long getMachineryId() {
        return machineryId;
    }

    public Date getAssignationInitDate() {
        return assignationInitDate;
    }

    public void setAssignationInitDate(Date assignationInitDate) {
        this.assignationInitDate = assignationInitDate;
    }

    public Date getAssignationEndDate() {
        return assignationEndDate;
    }

    public void setAssignationEndDate(Date assignationEndDate) {
        this.assignationEndDate = assignationEndDate;
    }

    public MachineryAssignation toDomain() {
        MachineryAssignation m = new MachineryAssignation();
        m.setId(getId());
        m.setAsignationInitDate(getAssignationInitDate());
        m.setAsingationEndDate(getAssignationEndDate());
        m.setCreatedOn(getCreatedOn());
        m.setUpdatedOn(getUpdatedOn());
        m.setEmployeeId(getEmployeeId());
        m.setMachineryId(getMachineryId());
        return m;
    }


}