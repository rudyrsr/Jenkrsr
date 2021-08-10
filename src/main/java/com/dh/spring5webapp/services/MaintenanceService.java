package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.MaintenanceCommand;
import com.dh.spring5webapp.model.Maintenance;

import java.util.List;

public interface MaintenanceService extends GenericService<Maintenance> {
    List<MaintenanceCommand> getAllMaintenance();

    Maintenance findByIdNotDeleted(Long id);

    Maintenance updateMaintence(MaintenanceCommand maintenance);

    void deleted(Long id);

}
