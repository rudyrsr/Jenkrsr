package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.Item;
import com.dh.spring5webapp.model.ItemAsignation;
import com.dh.spring5webapp.model.ModelBase;

import java.util.Date;

public class ItemAsignationCommand extends ModelBase {
    private Date initDateIA;
    private Date endDateIA;
    private Long id;
    private Long itemId;
    private Long employeeId;
    private String description;
    private String stateActual;
    private Item item;

    private EmployeeCommand employeeCommand;

    public ItemAsignationCommand() {
    }

    //mostrando al exterior
    public ItemAsignationCommand(ItemAsignation itemAsignation) {
        this.setInitDateIA(itemAsignation.getInitDateIA());
        this.setEndDateIA(itemAsignation.getEndDateIA());
        this.setId(itemAsignation.getId());
        this.setEmployeeId(itemAsignation.getEmpId());
        this.setItemId(itemAsignation.getItId());
        this.setDescription(itemAsignation.getDescription());
        this.setStateActual(itemAsignation.getStateActualItem());
        this.setCreatedOn(itemAsignation.getCreatedOn());
        this.setUpdatedOn(itemAsignation.getUpdatedOn());
        this.setVersion(itemAsignation.getVersion());

        //me creo un command para mostrar mi objeto json de item
        /*ItemCommand itemCommand = new ItemCommand();
        itemCommand.setCode(itemAsignation.getItem().getCode());
        itemCommand.setName(itemAsignation.getItem().getName());
        itemCommand.setDescription(itemAsignation.getItem().getDescription());
        itemCommand.setState(itemAsignation.getItem().getState());
        itemCommand.setPrice(itemAsignation.getItem().getPrice());
        itemCommand.setId(itemAsignation.getItem().getId());
        itemCommand.setUpdatedOn(itemAsignation.getItem().getUpdatedOn());
        itemCommand.setCreatedOn(itemAsignation.getItem().getCreatedOn());
        itemCommand.setVersion(itemAsignation.getItem().getVersion());
        itemCommand.setLabel(itemAsignation.getItem().getLabel());
        item = new Item(itemCommand);
        this.setItem(item);*/

        //me creo un command para mostrar mi objeto json de employee
        /*employeeCommand = new EmployeeCommand();
        employeeCommand.setFirstName(itemAsignation.getEmployee().getFirstName());
        employeeCommand.setLastName(itemAsignation.getEmployee().getLastName());
        employeeCommand.setId(itemAsignation.getEmployee().getId());
        employeeCommand.setCreatedOn(itemAsignation.getEmployee().getCreatedOn());
        employeeCommand.setUpdatedOn(itemAsignation.getEmployee().getUpdatedOn());
        employeeCommand.setVersion(itemAsignation.getEmployee().getVersion());
        this.setEmployeeCommand(employeeCommand);*/
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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStateActual() {
        return stateActual;
    }

    public void setStateActual(String stateActual) {
        this.stateActual = stateActual;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public EmployeeCommand getEmployeeCommand() {
        return employeeCommand;
    }

    public void setEmployeeCommand(EmployeeCommand employeeCommand) {
        this.employeeCommand = employeeCommand;
    }

    public ItemAsignation toItemAsignation() {
        ItemAsignation asignation = new ItemAsignation();
        asignation.setId(getId());
        asignation.setInitDateIA(getInitDateIA());
        asignation.setEndDateIA(getEndDateIA());
        asignation.setInitDateIA(getInitDateIA());
        asignation.setEndDateIA(getEndDateIA());
        asignation.setEmpId(getEmployeeId());
        asignation.setItId(getItemId());
        asignation.setDescription(getDescription());
        asignation.setStateActualItem(getStateActual());
        asignation.setCreatedOn(getCreatedOn());
        asignation.setUpdatedOn(getUpdatedOn());
        asignation.setVersion(getVersion());

        return asignation;

    }
}
