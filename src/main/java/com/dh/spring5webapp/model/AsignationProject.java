package com.dh.spring5webapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Asignation_Project")
public class AsignationProject extends ModelBase {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Project project;

    private Date asignationInitDate;
    private Date asingationEndDate;
    private boolean deleted;

    @Transient
    private Long employeId;
    @Transient
    private Long projectId;


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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Long getEmployeId() {
        return employeId;
    }

    public void setEmployeId(Long employeId) {
        this.employeId = employeId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
