package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.CatalogUCCommand;
import com.dh.spring5webapp.model.CatalogUC;
import com.dh.spring5webapp.repositories.CatalogUCRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogUCServiceImpl extends GenericServiceImpl<CatalogUC> implements CatalogUCService {
    private CatalogUCRepository catalogUCRepository;

    public CatalogUCServiceImpl(CatalogUCRepository catalogRepository) {

        this.catalogUCRepository = catalogRepository;
    }

    @Override
    public List<CatalogUCCommand> getAllCatalogsUC() {
        List<CatalogUCCommand> catalogList = verificarDelete();
        return catalogList;
    }

    @Override
    public CatalogUCCommand findByIdUC(Long id)
    {
        CatalogUCCommand catalogFactorInsecurity = new CatalogUCCommand(catalogUCRepository.findById(id).get());
        CatalogUCCommand res= new CatalogUCCommand();
        if (catalogFactorInsecurity.isDeleted() == false) {
            res = catalogFactorInsecurity;
        }
        return res;

    }
    @Override
    public CatalogUC CreateCatalogUC(CatalogUCCommand catalogUCCommand)
    {
        CatalogUC catalogUC1=new CatalogUC();
        catalogUC1 = catalogUCRepository.save(catalogUCCommand.toDomain());
        return catalogUC1;
    }
    public CatalogUC updateCatalogUC(CatalogUCCommand catalog){
        CatalogUC catalog1 = catalogUCRepository.findById(catalog.getId()).get();
        catalog1.setCatalogUCCode(catalog.getCatalogUCCode());
        catalog1.setCatalogUCName(catalog.getCatalogUCName());
        catalog1.setCatalogUCDescription(catalog.getCatalogUCDescription());
        CatalogUC itemPersisted = catalogUCRepository.save(catalog1);
        return itemPersisted;
    }
    @Override
    public void deleteIdUC(Long id)
    {
        catalogUCRepository.deleteById(id);

    }
    @Override
    public void desactivateCUC(Long id) {
        CatalogUC catalogUC = catalogUCRepository.findById(id).get();
        catalogUC.setDeleted(true);
        catalogUCRepository.save(catalogUC);
    }

    public List<CatalogUCCommand> verificarDelete() {
        List<CatalogUCCommand> fiCommands = new ArrayList<>();
        catalogUCRepository.findAll().forEach(catalogUC -> {
            fiCommands.add(new CatalogUCCommand(catalogUC));
        });
        List<CatalogUCCommand> fiCommandsR = new ArrayList<>();
        int i = 0;
        boolean valor = false;
        boolean resultado = false;
        while (fiCommands.size() > i) {
            valor = fiCommands.get(i).isDeleted();
            if (valor == false) {
                fiCommandsR.add(fiCommands.get(i));
            }
            i++;
        }
        return fiCommandsR;
    }
    @Override
    protected CrudRepository<CatalogUC, Long> getRepository() {
        return catalogUCRepository;
    }



}
