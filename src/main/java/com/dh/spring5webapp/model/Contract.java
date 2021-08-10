
package com.dh.spring5webapp.model;

import javax.persistence.*;

@Entity
@Table(name = "Contract")
public class Contract extends ModelBase {
    //    employee tipo Employee, position tipo Position, initDate, endDate  tipo Date.
    @OneToOne(orphanRemoval = true, fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    private Employee employee;
    @OneToOne(orphanRemoval = true, fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    private Position position;

    private String contractDescription;

    @Transient
    private Long employeeId;
    @Transient
    private Long positionId;

    private boolean deleted = false;

    public Contract() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getContractDescription() {
        return contractDescription;
    }

    public void setContractDescription(String contractDescription) {
        this.contractDescription = contractDescription;
    }
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
