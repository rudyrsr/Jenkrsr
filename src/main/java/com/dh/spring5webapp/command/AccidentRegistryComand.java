package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.Accident;
import com.dh.spring5webapp.model.AccidentRegistry;
import com.dh.spring5webapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;

public class AccidentRegistryComand {
    private Long accidentRid;
    private Date accidentRegistryDate;
    private LocalTime accidentRegistryHour;
    private Long accidentId;
    private Long employeeId;
    private boolean deleted;
    @Autowired
    private AccidentComand accident;
    @Autowired
    private EmployeeCommand employee;

    public AccidentRegistryComand() {
    }

    public AccidentRegistryComand(AccidentRegistry accidentRegistry) {
        this.setAccidentId(accidentRegistry.getAccident().getId());
        this.setEmployeeId(accidentRegistry.getEmployee().getId());
        this.setAccidentRid(accidentRegistry.getId());
        this.setAccidentRegistryDate(accidentRegistry.getAccidentRegistryDate());
        this.setAccidentRegistryHour(accidentRegistry.getAccidentRegistryHour());
        this.setDeleted(accidentRegistry.isDeleted());
        this.setEmployee(new EmployeeCommand(accidentRegistry.getEmployee()));
        this.setAccident(new AccidentComand(accidentRegistry.getAccident()));
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Long getAccidentRid() {
        return accidentRid;
    }

    public void setAccidentRid(Long accidentRid) {
        this.accidentRid = accidentRid;
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
        return accidentId;
    }

    public void setAccidentId(Long accidentId) {
        this.accidentId = accidentId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }


    public void setEmployee(EmployeeCommand employee) {
        this.employee = employee;

    }

    public AccidentComand getAccident() {
        return accident;
    }

    public void setAccident(AccidentComand accident) {
        this.accident = accident;
    }

    public EmployeeCommand getEmployee() {
        return employee;
    }


    public AccidentRegistry toDomain() {
        AccidentRegistry accidentRegistry = new AccidentRegistry();
        accidentRegistry.setId(getAccidentRid());
        accidentRegistry.setAccidentRegistryDate(getAccidentRegistryDate());
        accidentRegistry.setAccidentRegistryHour(getAccidentRegistryHour());
        accidentRegistry.setEmployeeId(getEmployeeId());
        accidentRegistry.setAccidentId(getAccidentId());
        return accidentRegistry;

    }
}

