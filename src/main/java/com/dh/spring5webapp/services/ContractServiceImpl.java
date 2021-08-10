package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.ContractCommand;
import com.dh.spring5webapp.model.Contract;
import com.dh.spring5webapp.model.MachineryAssignation;
import com.dh.spring5webapp.repositories.ContractRepository;
import com.dh.spring5webapp.repositories.EmployeeRepository;
import com.dh.spring5webapp.repositories.PositionRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractServiceImpl extends GenericServiceImpl<Contract> implements ContractService {
    private ContractRepository contractRepository;
    private EmployeeRepository employeeRepository;
    private PositionRepository positionRepository;

    public ContractServiceImpl(ContractRepository contractRepository, EmployeeRepository employeeRepository, PositionRepository positionRepository) {
        this.contractRepository = contractRepository;
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
    }

    @Override
    protected CrudRepository<Contract, Long> getRepository() {
        return contractRepository;
    }

    @Override
    public Contract update(Contract contractUpdate) {
        Contract contract = contractRepository.findById(contractUpdate.getId()).get();
        contract.setEmployeeId(contractUpdate.getEmployeeId());
        contract.setEmployee(employeeRepository.findById(contractUpdate.getEmployeeId()).orElse(null));
        contract.setPosition(positionRepository.findById(contractUpdate.getPositionId()).orElse(null));
        contract.setPositionId(contractUpdate.getPositionId());
        contract.setCreatedOn(contractUpdate.getCreatedOn());
        contract.setUpdatedOn(contractUpdate.getUpdatedOn());
        contract.setVersion(contractUpdate.getVersion());
        contract.setContractDescription(contractUpdate.getContractDescription());
        Contract contractPersisted = contractRepository.save(contract);
        return contractPersisted;
    }
    @Override
    public Contract findByIdNotDeleted(Long id) {
        Contract contract = contractRepository.findById(id).get();
        Contract res = new Contract();
        if (contract.isDeleted() == false) {
            res = contract;
        }
        return res;
    }

    @Override
    public List<ContractCommand> getAllContracts() {
        List<ContractCommand> machineryList = verificarDelete();
        return machineryList;
    }

    @Override
    public void deleted(Long id) {
        Contract contractToDelete = contractRepository.findById(id).get();
        contractToDelete.setDeleted(true);

        contractRepository.save(contractToDelete);
    }

    public List<ContractCommand> verificarDelete() {
        List<ContractCommand> contractCommands = new ArrayList<>();
        contractRepository.findAll().forEach(contract -> {
            if (contract.isDeleted()==false)
            {
            ContractCommand contractCommand = new ContractCommand(contract);
            contractCommands.add(contractCommand);
            }
        });
        return contractCommands;
    }
}
