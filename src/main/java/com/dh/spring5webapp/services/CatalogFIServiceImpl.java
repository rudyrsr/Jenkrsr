package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.CatalogFICommand;
import com.dh.spring5webapp.model.CatalogFI;
import com.dh.spring5webapp.repositories.CatalogFIRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CatalogFIServiceImpl extends GenericServiceImpl<CatalogFI> implements CatalogFIService {
    private CatalogFIRepository catalogFIRepository;

    public CatalogFIServiceImpl(CatalogFIRepository catalogFIRepository) {
        this.catalogFIRepository = catalogFIRepository;
    }
    @Override
    public List<CatalogFICommand> getAllCatalogsFI() {
        List<CatalogFICommand> catalogList = verificarDelete();
        return catalogList;
    }

    @Override
    public CatalogFICommand findByIdFI(Long id)
    {
        CatalogFICommand catalogFactorInsecurity = new CatalogFICommand(catalogFIRepository.findById(id).get());
        CatalogFICommand res= new CatalogFICommand();
        if (catalogFactorInsecurity.isDeleted() == false) {
            res = catalogFactorInsecurity;
        }
        return res;

    }
    @Override
    public CatalogFI CreateCatalogBI(CatalogFICommand catalogFICommand)
    {
        CatalogFI catalogFI1=new CatalogFI();
        catalogFI1 = catalogFIRepository.save(catalogFICommand.toDomain());
        return catalogFI1;
    }
    @Override
    public CatalogFI updateCatalogFI(CatalogFICommand catalogFacIns){
            CatalogFI facIns = catalogFIRepository.findById(catalogFacIns.getId()).get();
            facIns.setCatalogFIName(catalogFacIns.getCatalogFIName());
            facIns.setCatalogFIDescription(catalogFacIns.getCatalogFIDescription());
            facIns.setCatalogFICode(catalogFacIns.getCatalogFICode());
            CatalogFI itemPersisted = catalogFIRepository.save(facIns);
        return itemPersisted;
    }
    @Override
    public void deleteIdFI(Long id)
    {
        catalogFIRepository.deleteById(id);

    }
    @Override
    public void desactivateCFI(Long id) {
        CatalogFI catalogFI = catalogFIRepository.findById(id).get();
        catalogFI.setDeleted(true);
        catalogFIRepository.save(catalogFI);
    }

    public List<CatalogFICommand> verificarDelete() {
        List<CatalogFICommand> fiCommands = new ArrayList<>();
        catalogFIRepository.findAll().forEach(catalogFI -> {
            fiCommands.add(new CatalogFICommand(catalogFI));
        });
        List<CatalogFICommand> fiCommandsR = new ArrayList<>();
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
    protected CrudRepository<CatalogFI, Long> getRepository() {
        return null;
    }

}
