package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.AfflictionCommand;
import com.dh.spring5webapp.model.Affliction;
import com.dh.spring5webapp.repositories.AfflictionCatalogRepository;
import com.dh.spring5webapp.repositories.AfflictionRepository;
import com.dh.spring5webapp.repositories.EmployeeRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AfflictionServiceImpl extends GenericServiceImpl<Affliction> implements AfflictionService {
    private AfflictionRepository afflictionRepository;
    private EmployeeRepository employeeRepository;
    private AfflictionCatalogRepository catalogRepository;

    public AfflictionServiceImpl(AfflictionRepository afflictionRepository, EmployeeRepository employeeRepository, AfflictionCatalogRepository catalogRepository) {
        this.afflictionRepository = afflictionRepository;
        this.employeeRepository = employeeRepository;
        this.catalogRepository = catalogRepository;
    }

    @Override
    public Affliction findByIdNotDeleted(Long id) {
        Affliction affliction = afflictionRepository.findById(id).get();
        Affliction res = new Affliction();
        if (affliction.isDeleted() == false) {
            res = affliction;
        }
        return res;
    }

    @Override
    public Affliction update(Affliction afflictionUpdate) {
        //recupera una una instancia de Affliction dado un id<- model.id
        Affliction afflictionBD = afflictionRepository.findById(afflictionUpdate.getId()).get();
        //Settear los atributos en la instancia recuperada
        afflictionBD.setName(afflictionUpdate.getName());
        afflictionBD.setCode(afflictionUpdate.getCode());
        afflictionBD.setDescription(afflictionUpdate.getDescription());
        afflictionBD.setObservation(afflictionUpdate.getObservation());
        afflictionBD.setEmployee(employeeRepository.findById(afflictionUpdate.getEmployeeId()).orElse(null));
        afflictionBD.setAfflictionCatalog(catalogRepository.findById(afflictionUpdate.getAfflictionCatalogId()).orElse(null));
        afflictionBD.setRegistrationDate(afflictionUpdate.getRegistrationDate());
        //guardar la instancia
        Affliction afflictionPersisted = afflictionRepository.save(afflictionBD);
        return afflictionPersisted;
    }

    @Override
    public void delete(Long id) {
        Affliction afflictionToDelete = afflictionRepository.findById(id).get();
        afflictionToDelete.setDeleted(true);

        afflictionRepository.save(afflictionToDelete);


    }

    @Override
    public List<AfflictionCommand> getAllAfflictions() {
        List<AfflictionCommand> afflictionList = new ArrayList<>();
        afflictionRepository.findAff(false).forEach(affliction -> {
            afflictionList.add(new AfflictionCommand(affliction));
        });
        return afflictionList;

    }

    /*public List<AfflictionCommand> verificarDelete() {
        List<AfflictionCommand> afflictionList = new ArrayList<>();
        afflictionRepository.findAll().forEach(affliction -> {
            afflictionList.add(new AfflictionCommand(affliction));
        });
        List<AfflictionCommand> afflictionsR = new ArrayList<>();
        int i = 0;
        boolean valor = false;
        boolean resultado = false;
        while (afflictionList.size() > i) {
            valor = afflictionList.get(i).isDeleted();
            if (valor == false) {
                afflictionsR.add(afflictionList.get(i));
            }
            i++;
        }
        return afflictionsR;
    }*/

    @Override
    protected CrudRepository<Affliction, Long> getRepository() {
        return afflictionRepository;
    }

}

