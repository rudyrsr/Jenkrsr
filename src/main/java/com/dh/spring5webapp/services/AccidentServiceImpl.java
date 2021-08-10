package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.AccidentComand;
import com.dh.spring5webapp.model.Accident;
import com.dh.spring5webapp.model.CatalogFI;
import com.dh.spring5webapp.model.CatalogUA;
import com.dh.spring5webapp.model.Employee;
import com.dh.spring5webapp.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


import com.dh.spring5webapp.repositories.AccidentRepository;
import com.dh.spring5webapp.repositories.EmployeeRepository;

import java.util.Optional;


@Service
public class AccidentServiceImpl extends GenericServiceImpl<Accident> implements AccidentService {
    @Autowired
    private AccidentRepository accidentRepository;
    @Autowired
    private CatalogUCRepository catalogUCRepository;
    @Autowired
    private CatalogTDRepository catalogTDRepository;
    @Autowired
    private CatalogNIRepository catalogNIRepository;
    @Autowired
    private CatalogUARepository catalogUARepository;
    @Autowired
    private CatalogFIRepository catalogFIRepository;

    public AccidentServiceImpl() {
    }
    public AccidentServiceImpl(AccidentRepository accidentRepository) {
        this.accidentRepository = accidentRepository;
    }

    @Override
    public List<AccidentComand> getAllaccidents() {
        List<AccidentComand> accidentList = verificarDelete();
        return accidentList;

    }

    @Override
    public AccidentComand findByIdA(Long id) {
        AccidentComand accidentComand = new AccidentComand(accidentRepository.findById(id).get());
        AccidentComand res = new AccidentComand();
        if (accidentComand.isDeleted() == false) {
            res = accidentComand;
        }
        return res;
    }
    @Override
    public AccidentComand findCodeAccidents(String code) {
        AccidentComand accidentList = findCodigoAccident(code) ;
        return accidentList;

    }

    @Override
    public Accident CreateAccident(AccidentComand accident) {
        Accident model = accident.toDomain();
        model.setCatalogFI(catalogFIRepository.findById(accident.getCatalogFI_id()).get());
        model.setCatalogNI(catalogNIRepository.findById(accident.getCatalogNI_id()).get());
        model.setCatalogTD(catalogTDRepository.findById(accident.getCatalogTD_id()).get());
        model.setCatalogUA(catalogUARepository.findById(accident.getCatalogUA_id()).get());
        model.setCatalogUC(catalogUCRepository.findById(accident.getCatalogUC_id()).get());
        return accidentRepository.save(model);
    }

    @Override
    public Accident updateAccident(AccidentComand accident) {
        Accident accident1 = accidentRepository.findById(accident.getId()).get();
        accident1.setAccidentCode(accident.getAccidentCode());
        accident1.setAccidentPlace(accident.getAccidentPlace());
        accident1.setAccidentSupervisor(accident.getAccidentSupervisor());
        accident1.setAccidentWitness(accident.getAccidentWitness());
        accident1.setAccidentMedicalCenter(accident.getAccidentMedicalCenter());
        accident1.setAccidentDisabilityDay(accident.getAccidentDisabilityDay());
        accident1.setCatalogFI_id(accident.getCatalogFI_id());
        accident1.setCatalogNI_id(accident.getCatalogNI_id());
        accident1.setCatalogTD_id(accident.getCatalogTD_id());
        accident1.setCatalogUA_id(accident.getCatalogUA_id());
        accident1.setCatalogUC_id(accident.getCatalogUC_id());
        accident1.setCatalogUC(catalogUCRepository.findById(accident.getCatalogUC_id()).get());
        accident1.setCatalogUA(catalogUARepository.findById(accident.getCatalogUA_id()).get());
        accident1.setCatalogTD(catalogTDRepository.findById(accident.getCatalogTD_id()).get());
        accident1.setCatalogNI(catalogNIRepository.findById(accident.getCatalogNI_id()).get());
        accident1.setCatalogFI(catalogFIRepository.findById(accident.getCatalogFI_id()).get());
        Accident accidentimplpersis = accidentRepository.save(accident1);
        return accidentimplpersis;
    }

    @Override
    public void desactivateAccident(Long id) {
        Accident accident = accidentRepository.findById(id).get();
        accident.setDeleted(true);
        accidentRepository.save(accident);
    }

    @Override
    public void deleteAccident(Long id) {

        accidentRepository.deleteById(id);
    }

    public List<AccidentComand> verificarDelete() {
        List<AccidentComand> accidentComandList = new ArrayList<>();
        accidentRepository.findAll().forEach(accident -> {
            accidentComandList.add(new AccidentComand(accident));
        });
        List<AccidentComand> accidentComandsR = new ArrayList<>();
        int i = 0;
        boolean valor = false;
        boolean resultado = false;
        while (accidentComandList.size() > i) {
            valor = accidentComandList.get(i).isDeleted();
            if (valor == false) {
                accidentComandsR.add(accidentComandList.get(i));
            }
            i++;
        }
        return accidentComandsR;
    }
    public AccidentComand findCodigoAccident(String codigo)
    {
        List<AccidentComand> accidentComandList = new ArrayList<>();
        accidentRepository.findAll().forEach(accident -> {
            accidentComandList.add(new AccidentComand(accident));
        });
        AccidentComand accidentComandsR = new AccidentComand();
        int i = 0;
        String valor = "";
        AccidentComand resultado = new AccidentComand();
        while (accidentComandList.size() > i) {
            valor = accidentComandList.get(i).getAccidentCode();
            if (valor.equals(codigo)) {
                accidentComandsR=accidentComandList.get(i);
            }
            i++;
        }
        return accidentComandsR;
    }
    @Override
    protected CrudRepository<Accident, Long> getRepository() {
        return accidentRepository;
    }
}
