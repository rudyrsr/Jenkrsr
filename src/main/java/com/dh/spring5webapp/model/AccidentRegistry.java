package com.dh.spring5webapp.model;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;
@Entity
@Table(name = "Accident_Registry")
public class AccidentRegistry extends ModelBase{

    @Column(name="accidentRegistryDate")
    private Date accidentRegistryDate;

    @Column(name="accidentRegistryHour")
    private LocalTime accidentRegistryHour;

    @Column(name="deleted")
    private boolean deleted=false;

    @Transient
    private Long AccidentId;
    @Transient
    private Long employeeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="accident_id")
    private Accident accident;


    public AccidentRegistry() {
    }


    public AccidentRegistry(Date accidentRegistryDate,LocalTime accidentRegistryHour, Long accidentId, Long employeeId, Employee employee, Accident accident,boolean deleted) {
        this.accidentRegistryDate = accidentRegistryDate;
        this.accidentRegistryHour = accidentRegistryHour;
        this.AccidentId = accidentId;
        this.employeeId = employeeId;
        this.employee = employee;
        this.accident = accident;
        this.deleted=deleted;
    }


    public Date getAccidentRegistryDate() {
        return accidentRegistryDate;
    }

    public void setAccidentRegistryDate(Date accidentRegistryDate) {
        this.accidentRegistryDate = accidentRegistryDate;
    }

    public LocalTime getAccidentRegistryHour() {
        return accidentRegistryHour;
    }

    public void setAccidentRegistryHour(LocalTime accidentRegistryHour) {
        this.accidentRegistryHour = accidentRegistryHour;
    }

    public Long getAccidentId() {
        return AccidentId;
    }

    public void setAccidentId(Long accidentId) {
        AccidentId = accidentId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Accident getAccident() {
        return accident;
    }

    public void setAccident(Accident accident) {
        this.accident = accident;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
