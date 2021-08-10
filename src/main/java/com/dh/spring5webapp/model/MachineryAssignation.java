package com.dh.spring5webapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Machinery_Assignation")
public class MachineryAssignation extends ModelBase{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "machinery_id")
    private Machinery machinery;

    @Transient
    private Long employeeId;
    @Transient
    private Long machineryId;

    private Date asignationInitDate;
    private Date asingationEndDate;
    private boolean deleted = false;




    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setMachineryId(Long machineryId) {
        this.machineryId = machineryId;
    }

    public Long getEmployeeId() {

        return employeeId;
    }

    public Long getMachineryId() {
        return machineryId;
    }


    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setMachinery(Machinery machinery) {
        this.machinery = machinery;
    }

    public Employee getEmployee() {

        return employee;
    }

    public Machinery getMachinery() {
        return machinery;
    }

    public Date getAsignationInitDate() {
        return asignationInitDate;
    }

    public void setAsignationInitDate(Date asignationInitDate) {
        this.asignationInitDate = asignationInitDate;
    }

    public Date getAsingationEndDate() {
        return asingationEndDate;
    }

    public void setAsingationEndDate(Date asingationEndDate) {
        this.asingationEndDate = asingationEndDate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
