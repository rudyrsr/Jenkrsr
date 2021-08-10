
package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.AsignationProject;
import com.dh.spring5webapp.model.ModelBase;

import java.util.Date;


public class AsignationProjectCommand extends ModelBase {

    private Date assignationInitDate;
    private Date assignationEndDate;
    private Long projectId;
    private Long employeeId;
    private boolean deleted;

    private ProjectCommand projectCM;
    private EmployeeCommand employeeCM;


    public AsignationProjectCommand(AsignationProject asignationProject) {

        this.setId(asignationProject.getId());
        this.setAssignationInitDate(asignationProject.getAsignationInitDate());
        this.setAssignationEndDate(asignationProject.getAsingationEndDate());
        this.setEmployeeId(asignationProject.getEmployee().getId());
        this.setProjectId(asignationProject.getProject().getId());
        this.setDeleted(asignationProject.isDeleted());

        this.setCreatedOn(asignationProject.getCreatedOn());
        this.setUpdatedOn(asignationProject.getUpdatedOn());


        this.setEmployeeCM(new EmployeeCommand(asignationProject.getEmployee()));
        this.setProjectCM(new ProjectCommand(asignationProject.getProject()));


    }

    public AsignationProjectCommand() {
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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public ProjectCommand getProjectCM() {
        return projectCM;
    }

    public void setProjectCM(ProjectCommand projectCM) {
        this.projectCM = projectCM;
    }

    public EmployeeCommand getEmployeeCM() {
        return employeeCM;
    }

    public void setEmployeeCM(EmployeeCommand employeeCM) {
        this.employeeCM = employeeCM;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public AsignationProject toDomain() {
        AsignationProject assignation = new AsignationProject();
        assignation.setId(getId());
        assignation.setAsignationInitDate(getAssignationInitDate());
        assignation.setAsingationEndDate(getAssignationEndDate());
        assignation.setProjectId(getProjectId());
        assignation.setEmployeId(getEmployeeId());
        return assignation;
    }
}
