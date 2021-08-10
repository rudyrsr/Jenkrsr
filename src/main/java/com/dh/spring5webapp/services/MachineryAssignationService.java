package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.MachineryAssignationCommand;
import com.dh.spring5webapp.model.MachineryAssignation;

import java.util.List;

public interface MachineryAssignationService extends GenericService<MachineryAssignation> {
    MachineryAssignation update(MachineryAssignation machineryAssignation);

    MachineryAssignation findByIdNotDeleted(Long id);

    List<MachineryAssignationCommand> getAllMachineryAssignation();


    void deleted(Long id);

}
