package com.dh.spring5webapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Item_Asignation")
public class ItemAsignation extends ModelBase {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    private Item item;

    private Date initDateIA;
    private Date endDateIA;
    private String description;

    //id de empleado para obtener sus datos
    //@Transient
    private Long empId;
    //id de item para obtener sus datos
    //@Transient
    private Long itId;

    private String stateActualItem;

    public ItemAsignation() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Date getInitDateIA() {
        return initDateIA;
    }

    public void setInitDateIA(Date initDateIA) {
        this.initDateIA = initDateIA;
    }

    public Date getEndDateIA() {
        return endDateIA;
    }

    public void setEndDateIA(Date endDateIA) {
        this.endDateIA = endDateIA;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Long getItId() {
        return itId;
    }

    public void setItId(Long itId) {
        this.itId = itId;
    }

    public String getStateActualItem() {
        return stateActualItem;
    }

    public void setStateActualItem(String stateActualItem) {
        this.stateActualItem = stateActualItem;
    }
}
