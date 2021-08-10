package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.MaintenanceCommand;
import com.dh.spring5webapp.model.Machinery;
import com.dh.spring5webapp.model.Maintenance;
import com.dh.spring5webapp.repositories.MachineryRepository;
import com.dh.spring5webapp.repositories.MaintenanceRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaintenanceServiceImpl extends GenericServiceImpl<Maintenance> implements MaintenanceService {
    private final MaintenanceRepository maintenanceRepository;
    private final MachineryRepository machineryRepository;

    public MaintenanceServiceImpl(MaintenanceRepository maintenanceRepository, MachineryRepository machineryRepository) {
        this.maintenanceRepository = maintenanceRepository;
        this.machineryRepository = machineryRepository;
    }

    @Override
    public Maintenance save(Maintenance model) {
        model.setMachinery(machineryRepository.findById(model.getMachineryid()).orElse(null));
        return super.save(model);
    }

    @Override

    public Maintenance updateMaintence(MaintenanceCommand maintenance) {
        Maintenance maintenance1 = maintenanceRepository.findById(maintenance.getId()).get();
        Machinery machineryN = machineryRepository.findById(maintenance.getMachineryId()).get();
        maintenance1.setCode(maintenance.getMaintenanceCode());
        maintenance1.setObservation(maintenance.getMaintenanceObservation());
        maintenance1.setDescription(maintenance.getMaintenanceDescription());
        maintenance1.setPrice(maintenance.getMaintenancePrice());
        maintenance1.setTimelineinitdate(maintenance.getMaintenanceTimeLineInitDate());
        maintenance1.setTimelineenddate(maintenance.getMaintenanceTimeLineEndDate());
        maintenance1.setMachinery(machineryN);
        Maintenance maintenancePersiste = maintenanceRepository.save(maintenance1);

        return maintenancePersiste;
    }

    @Override
    public void deleted(Long id) {
        Maintenance maintenanceToDelete = maintenanceRepository.findById(id).get();
        maintenanceToDelete.setDeleted(true);

        maintenanceRepository.save(maintenanceToDelete);


    }

    @Override
    protected CrudRepository<Maintenance, Long> getRepository() {
        return maintenanceRepository;
    }

    @Override
    public List<MaintenanceCommand> getAllMaintenance() {
        List<MaintenanceCommand> machineryList = verificarDelete();
        return machineryList;

    }

    public List<MaintenanceCommand> verificarDelete() {
        List<MaintenanceCommand> machineryList = new ArrayList<>();
        maintenanceRepository.findAll().forEach(machineryCatalog -> {
            machineryList.add(new MaintenanceCommand(machineryCatalog));
        });
        List<MaintenanceCommand> machineryR = new ArrayList<>();
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
    public Maintenance findByIdNotDeleted(Long id) {
        Maintenance machinery = maintenanceRepository.findById(id).get();
        Maintenance res = new Maintenance();
        if (machinery.isDeleted() == false) {
            res = machinery;
        }
        return res;
    }
}
