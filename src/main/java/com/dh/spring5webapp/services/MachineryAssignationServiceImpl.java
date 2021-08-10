package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.MachineryAssignationCommand;
import com.dh.spring5webapp.model.MachineryAssignation;
import com.dh.spring5webapp.repositories.EmployeeRepository;
import com.dh.spring5webapp.repositories.MachineryAssignationRepository;
import com.dh.spring5webapp.repositories.MachineryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MachineryAssignationServiceImpl extends GenericServiceImpl<MachineryAssignation> implements MachineryAssignationService {
    private static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private MachineryAssignationRepository machineryAssignationRepository;
    private final EmployeeRepository employeeRepository;
    private final MachineryRepository machineryRepository;

    public MachineryAssignationServiceImpl(MachineryAssignationRepository machineryAssignationRepository, EmployeeRepository employeeRepository, MachineryRepository machineryRepository) {
        this.machineryAssignationRepository = machineryAssignationRepository;
        this.employeeRepository = employeeRepository;
        this.machineryRepository = machineryRepository;
    }

    @Override
    protected CrudRepository<MachineryAssignation, Long> getRepository() {

        return machineryAssignationRepository;
    }
    @Override
    public MachineryAssignation update(MachineryAssignation machineryAssignationUpdate)
    {
        MachineryAssignation machineryAssignation = machineryAssignationRepository.findById(machineryAssignationUpdate.getId()).get();
        machineryAssignation.setAsignationInitDate(machineryAssignationUpdate.getAsignationInitDate());
        machineryAssignation.setAsingationEndDate(machineryAssignationUpdate.getAsingationEndDate());
        machineryAssignation.setUpdatedOn(machineryAssignationUpdate.getUpdatedOn());
        machineryAssignation.setCreatedOn(machineryAssignationUpdate.getCreatedOn());
        machineryAssignation.setMachinery(machineryRepository.findById(machineryAssignationUpdate.getMachineryId()).orElse(null));
        machineryAssignation.setEmployee(employeeRepository.findById(machineryAssignationUpdate.getEmployeeId()).orElse(null));
        MachineryAssignation machineryAssignationPersisted = machineryAssignationRepository.save(machineryAssignation);
        return machineryAssignationPersisted;
    }

    @Override
    public MachineryAssignation findByIdNotDeleted(Long id) {
        MachineryAssignation machinery = machineryAssignationRepository.findById(id).get();
        MachineryAssignation res = new MachineryAssignation();
        if (machinery.isDeleted() == false) {
            res = machinery;
        }
        return res;
    }

    @Override
    public List<MachineryAssignationCommand> getAllMachineryAssignation() {
        List<MachineryAssignationCommand> machineryList = verificarDelete();
        return machineryList;
    }

    public List<MachineryAssignationCommand> verificarDelete() {
        List<MachineryAssignationCommand> machineryList = new ArrayList<>();
        machineryAssignationRepository.findAll().forEach(machineryCatalog -> {
            machineryList.add(new MachineryAssignationCommand(machineryCatalog));
        });
        List<MachineryAssignationCommand> machineryR = new ArrayList<>();
        int i = 0;
        boolean valor = false;
        boolean resultado = false;
        while (machineryList.size() > i) {
            valor = machineryList.get(i).isDeleted();
            if (valor == false) {
                machineryR.add(machineryList.get(i));
            }
            i++;
        }
        return machineryR;

    }

    @Override
    public void deleted(Long id) {
        MachineryAssignation machineryAssignationToDelete = machineryAssignationRepository.findById(id).get();
        machineryAssignationToDelete.setDeleted(true);

        machineryAssignationRepository.save(machineryAssignationToDelete);

    }
}
