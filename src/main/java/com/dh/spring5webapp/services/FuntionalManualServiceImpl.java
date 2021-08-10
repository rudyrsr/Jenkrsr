package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.FuntionalManualCommand;
import com.dh.spring5webapp.model.FuntionalManual;
import com.dh.spring5webapp.repositories.FuntionalManualRepository;
import com.dh.spring5webapp.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FuntionalManualServiceImpl extends GenericServiceImpl<FuntionalManual> implements FuntionalManualService {
    @Autowired
    private FuntionalManualRepository funtionalManualRepository;
    @Autowired
    private PositionRepository positionRepository;

    public FuntionalManualServiceImpl(FuntionalManualRepository funtionalManualRepository, PositionRepository positionRepository) {
        this.funtionalManualRepository = funtionalManualRepository;
        this.positionRepository = positionRepository;
    }


    @Override
    public List<FuntionalManualCommand> getAllFunctionalManual() {
        List<FuntionalManualCommand> catalogList = verificarDelete();
        return catalogList;
    }

    public List<FuntionalManualCommand> verificarDelete() {
        List<FuntionalManualCommand> catalogList = new ArrayList<>();
        funtionalManualRepository.findAll().forEach(catalog -> {
            catalogList.add(new FuntionalManualCommand(catalog));
        });
        List<FuntionalManualCommand> notDeleted = new ArrayList<>();
        int i = 0;
        boolean valor = false;
        while (catalogList.size() > i) {
            valor = catalogList.get(i).isDeleted();
            if (valor == false) {
                notDeleted.add(catalogList.get(i));
            }
            i++;
        }
        return notDeleted;
    }

    @Override
    public FuntionalManual findByIdNotDeleted(Long id) {
        FuntionalManual functionalManual = funtionalManualRepository.findById(id).get();
        FuntionalManual res = new FuntionalManual();
        if (functionalManual.isDeleted() == false) {
            res = functionalManual;
        }
        return res;
    }


    @Override
    public FuntionalManualCommand update(FuntionalManualCommand funtionalManual) {
        FuntionalManual funtionalManual1 = funtionalManualRepository.findById(funtionalManual.getId()).get();
        funtionalManual1.setName(funtionalManual.getFunctionalmanualName());
        funtionalManual1.setDate(funtionalManual.getFunctionalmanualDate());
        funtionalManual1.setDescription(funtionalManual.getFunctionalmanualDescription());
        funtionalManual1.setUrl(funtionalManual.getFunctionalmanualUrl());
        funtionalManual1.setOrganitationalLevel(funtionalManual.getOrganitationalLevel());
        funtionalManual1.setPositionid(funtionalManual.getPositionId());
        funtionalManual1.setEducationLevel(funtionalManual.getEducationLevel());
        funtionalManual1.setCode(funtionalManual.getFunctionalmanualCode());
        funtionalManual1 = funtionalManualRepository.save(funtionalManual1);
        return new FuntionalManualCommand(funtionalManual1);
    }

    @Override
    public void delete(Long id) {
        FuntionalManual functionalManualToDelete = funtionalManualRepository.findById(id).get();
        functionalManualToDelete.setDeleted(true);
        funtionalManualRepository.save(functionalManualToDelete);
    }

    @Override
    protected CrudRepository<FuntionalManual, Long> getRepository() {
        return funtionalManualRepository;
    }
}
