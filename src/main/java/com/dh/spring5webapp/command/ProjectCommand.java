
package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.ModelBase;
import com.dh.spring5webapp.model.Project;
import org.apache.tomcat.util.codec.binary.Base64;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class ProjectCommand extends ModelBase {

    private String projectName;
    private String projectCode;
    private String porjectLabel;
    private String projectDescription;
    private String projectLocation;
    private Date projectInitDate;
    private Date projectEndDate;
    private String image;
    private boolean activate = true;
    private boolean deleted;
    // private Set<AsignationProject> asignationProjectList;
    private Set<EmployeeCommand> employees = new HashSet<>();

    public ProjectCommand(Project project) {

        this.setId(project.getId());
        this.setProjectName(project.getName());
        this.setProjectCode(project.getCode());
        this.setPorjectLabel(project.getCode());
        this.setProjectDescription(project.getDescription());
        this.setProjectLocation(project.getLocation());
        this.setProjectInitDate(project.getInitDate());
        this.setProjectEndDate(project.getEndDate());
        this.setCreatedOn(project.getCreatedOn());
        this.setUpdatedOn(project.getUpdatedOn());
        project.getAsignationProjectList().forEach(
                asignationProject -> this.employees.add(new EmployeeCommand(asignationProject.getEmployee())));
        //this.setAsignationProjectList(project.getAsignationProjectList());
        if (project.getImage() != null) {
            byte[] bytes = new byte[project.getImage().length];
            for (int i = 0; i < project.getImage().length; i++) {
                bytes[i] = project.getImage()[i];
            }
            String imageStr = Base64.encodeBase64String(bytes);
            this.setImage(imageStr);
        }
        this.setActivate(project.isActivate());
        this.setDeleted(project.isDeleted());
    }

    public ProjectCommand() {
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectLocation() {
        return projectLocation;
    }

    public void setProjectLocation(String projectLocation) {
        this.projectLocation = projectLocation;
    }

    public Date getProjectInitDate() {
        return projectInitDate;
    }

    public void setProjectInitDate(Date projectInitDate) {
        this.projectInitDate = projectInitDate;
    }

    public Date getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(Date projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPorjectLabel() {
        return porjectLabel;
    }

    public void setPorjectLabel(String porjectLabel) {
        this.porjectLabel = getProjectCode() + "-" + getId();
    }

    /*public Set<AsignationProject> getAsignationProjectList() {
        return asignationProjectList;
    }

    public void setAsignationProjectList(Set<AsignationProject> asignationProjectList) {
        this.asignationProjectList = asignationProjectList;
    }*/

    public Set<EmployeeCommand> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeCommand> employees) {
        this.employees = employees;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Project toDomain() {
        Project project = new Project();
        project.setCode(getProjectCode());
        project.setName(getProjectName());
        project.setDescription(getProjectDescription());
        project.setLocation(getProjectLocation());
        project.setCreatedOn(getCreatedOn());
        project.setUpdatedOn(getUpdatedOn());
        project.setInitDate(getProjectInitDate());
        project.setEndDate(getProjectEndDate());
        //project.setAsignationProjectList(getAsignationProjectList());
        project.setAsignationProjectId(getId());
        project.setId(getId());
        project.setActivate(isActivate());
        return project;
    }
}
