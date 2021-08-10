package com.dh.spring5webapp.command;

import com.dh.spring5webapp.model.Contract;
import com.dh.spring5webapp.model.ModelBase;

public class ContractCommand extends ModelBase {
    private Long id;
    private Long employeeId;
    private Long positionId;
    private String contractDescription;
    private PositionCommand positionCommand;
    private EmployeeCommand employeeCommand;



    public ContractCommand(Contract contract)
    {
        this.setEmployeeId(contract.getEmployee().getId());
        this.setPositionId(contract.getPosition().getId());
        this.setId(contract.getId());
        this.setCreatedOn(contract.getCreatedOn());
        this.setUpdatedOn(contract.getUpdatedOn());
        this.setContractDescription(contract.getContractDescription());
        this.setPositionCommand(new PositionCommand(contract.getPosition()));
        this.setEmployeeCommand(new EmployeeCommand(contract.getEmployee()));
    }

    public ContractCommand() {
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Long getId() {

        return id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Long getPositionId() {
        return positionId;
    }

    public String getContractDescription() {
        return contractDescription;
    }

    public void setContractDescription(String contractDescription) {
        this.contractDescription = contractDescription;
    }
    public PositionCommand getPositionCommand() {
        return positionCommand;
    }

    public EmployeeCommand getEmployeeCommand() {
        return employeeCommand;
    }

    public void setPositionCommand(PositionCommand positionCommand) {
        this.positionCommand = positionCommand;
    }

    public void setEmployeeCommand(EmployeeCommand employeeCommand) {
        this.employeeCommand = employeeCommand;
    }

    public Contract toContract()
    {
        Contract contract = new Contract();
        contract.setId(getId());
        contract.setCreatedOn(getCreatedOn());
        contract.setUpdatedOn(getUpdatedOn());
        contract.setEmployeeId(getEmployeeId());
        contract.setPositionId(getPositionId());
        contract.setContractDescription(getContractDescription());
        return contract;
    }
}
