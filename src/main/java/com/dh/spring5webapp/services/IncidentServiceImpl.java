package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.IncidentCommand;
import com.dh.spring5webapp.model.Incident;
import com.dh.spring5webapp.repositories.EmployeeRepository;
import com.dh.spring5webapp.repositories.IncidentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class IncidentServiceImpl extends GenericServiceImpl<Incident> implements IncidentService {
    private static Logger logger = LoggerFactory.getLogger(IncidentServiceImpl.class);
    private final IncidentRepository incidentRepository;
    private final EmployeeRepository employeeRepository;
    private IncidentCatalogService catalogService;

    public IncidentServiceImpl(IncidentRepository incidentRepository, EmployeeRepository employeeRepository, IncidentCatalogService catalogService) {
        this.incidentRepository = incidentRepository;
        this.employeeRepository = employeeRepository;
        this.catalogService = catalogService;
    }

    @Override
    public Incident save(Incident model) {
        model.setEmployee(employeeRepository.findById(model.getEmployeeId()).orElse(null));
        return super.save(model);
    }
    //CRUD
    //List all Incidents
    @Override
    public List<IncidentCommand> getAllIncidents() {
        List<IncidentCommand> incidentList = new ArrayList<>();
        incidentRepository.findIncid(false).forEach(incident -> {
            incidentList.add(new IncidentCommand(incident));
        });
        return incidentList;
    }

//    public List<IncidentCommand> verificarDelete() {
//        List<IncidentCommand> incidenteList = new ArrayList<>();
//        incidentRepository.findAll().forEach(incident -> {
//            incidenteList.add(new IncidentCommand(incident));
//        });
//        List<IncidentCommand> notDeleted = new ArrayList<>();
//        int i = 0;
//        boolean valor = false;
//        while (incidenteList.size() > i) {
//            valor = incidenteList.get(i).isDeleted();
//            if (valor == false) {
//                notDeleted.add(incidenteList.get(i));
//            }
//            i++;
//        }
//        return notDeleted;
//    }

    @Override
    public Incident findByIdNotDeleted(Long id) {
        Incident incident = incidentRepository.findById(id).get();
        Incident res = new Incident();
        if (incident.isDeleted() == false) {
            res = incident;
        }
        return res;
    }


    //update  Incident
    @Override
    public Incident update(Incident incidentUpdate) {
        //recuperar una instacia de indicente dado un id
        Incident incidentBD = incidentRepository.findById(incidentUpdate.getId()).get();
        //Settear los atributos en la instancia recuperada
        incidentBD.setCode(incidentUpdate.getCode());
        incidentBD.setDescription(incidentUpdate.getDescription());
        incidentBD.setEmployee(employeeRepository.findById(incidentUpdate.getEmployeeId()).orElse(null));
        incidentBD.setIncidentCatalog(catalogService.findById(incidentUpdate.getIncidentCatalogId()));
        incidentBD.setObservations(incidentUpdate.getObservations());
        incidentBD.setImage(incidentUpdate.getImage());
        incidentBD.setRegistrationDate(incidentUpdate.getRegistrationDate());
        incidentBD.setWitness(incidentUpdate.getWitness());
        incidentBD.setPlace(incidentUpdate.getPlace());
        //guardamos la instacia
        Incident incidentPersisted = incidentRepository.save(incidentBD);
        return incidentPersisted;
    }



    @Override
    public void saveImage(Long id, InputStream file) {
        Incident incidentPersisted = findById(id);
        try {
            Byte[] bytes = ImageUtils.inputStreamToByteArray(file);
            incidentPersisted.setImage(bytes);
            getRepository().save(incidentPersisted);
        } catch (IOException e) {
            logger.error("Error reading file", e);
            e.printStackTrace();
        }
    }


    @Override
    protected CrudRepository<Incident, Long> getRepository() {
        return incidentRepository;
    }


    @Override
    public void delete(Long id) {
        Incident incidentToDelete = incidentRepository.findById(id).get();
        incidentToDelete.setDeleted(true);

        incidentRepository.save(incidentToDelete);

    }
}

