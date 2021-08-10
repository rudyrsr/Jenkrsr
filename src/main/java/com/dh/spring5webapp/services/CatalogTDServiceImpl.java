package com.dh.spring5webapp.services;


import com.dh.spring5webapp.command.CatalogTDCommand;
import com.dh.spring5webapp.model.CatalogTD;
import com.dh.spring5webapp.repositories.CatalogTDRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogTDServiceImpl extends GenericServiceImpl<CatalogTD> implements CatalogTDService{
    private CatalogTDRepository catalogTDRepository;

    public CatalogTDServiceImpl(CatalogTDRepository catalogTDRepository) {
        this.catalogTDRepository = catalogTDRepository;
    }
    @Override
    public List<CatalogTDCommand> getAllCatalogsTD() {
        List<CatalogTDCommand> catalogList = verificarDelete();
        return catalogList;
    }

    @Override
    public CatalogTDCommand findByIdTD(Long id)
    {
        CatalogTDCommand catalogFactorInsecurity = new CatalogTDCommand(catalogTDRepository.findById(id).get());
        CatalogTDCommand res= new CatalogTDCommand();
        if (catalogFactorInsecurity.isDeleted() == false) {
            res = catalogFactorInsecurity;
        }
        return res;

    }
    @Override
    public CatalogTD CreateCatalogBI(CatalogTDCommand catalogTDCommand)
    {
        CatalogTD catalogTD1=new CatalogTD();
        catalogTD1 = catalogTDRepository.save(catalogTDCommand.toDomain());
        return catalogTD1;
    }
    @Override
    public CatalogTD updateCatalogTD(CatalogTDCommand catalogFacIns){
        CatalogTD facIns = catalogTDRepository.findById(catalogFacIns.getId()).get();
        facIns.setCatalogTDName(catalogFacIns.getCatalogTDName());
        facIns.setCatalogTDDescription(catalogFacIns.getCatalogTDDescription());
        facIns.setCatalogTDCode(catalogFacIns.getCatalogTDCode());
        CatalogTD itemPersisted = catalogTDRepository.save(facIns);
        return itemPersisted;
    }
    @Override
    public void deleteIdTD(Long id)
    {
        catalogTDRepository.deleteById(id);

    }
    @Override
    public void desactivateCTD(Long id) {
        CatalogTD catalogTD = catalogTDRepository.findById(id).get();
        catalogTD.setDeleted(true);
        catalogTDRepository.save(catalogTD);
    }
    public List<CatalogTDCommand> verificarDelete() {
        List<CatalogTDCommand> fiCommands = new ArrayList<>();
        catalogTDRepository.findAll().forEach(catalogTD -> {
            fiCommands.add(new CatalogTDCommand(catalogTD));
        });
        List<CatalogTDCommand> fiCommandsR = new ArrayList<>();
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
    protected CrudRepository<CatalogTD, Long> getRepository() {
        return null;
    }

}
