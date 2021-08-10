package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.ContractCommand;
import com.dh.spring5webapp.model.Contract;

import java.util.List;

public interface ContractService extends GenericService<Contract> {
    public Contract update(Contract contract);
    public Contract findByIdNotDeleted(Long id);
    public List<ContractCommand> getAllContracts();
    public void deleted(Long id);
}
