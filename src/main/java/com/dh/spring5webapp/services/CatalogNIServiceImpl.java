package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.CatalogNICommand;
import com.dh.spring5webapp.model.CatalogNI;
import com.dh.spring5webapp.repositories.CatalogFIRepository;
import com.dh.spring5webapp.repositories.CatalogNIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogNIServiceImpl extends GenericServiceImpl<CatalogNI> implements CatalogNIService{
    private CatalogNIRepository catalogNIRepository;


    public CatalogNIServiceImpl(CatalogNIRepository catalogNIRepository) {
        this.catalogNIRepository = catalogNIRepository;
    }
    @Override
    public List<CatalogNICommand> getAllCatalogsNI() {
        List<CatalogNICommand> catalogList = verificarDelete();
        return catalogList;
    }

    @Override
    public CatalogNICommand findByIdNI(Long id)
    {
        CatalogNICommand catalogFactorInsecurity = new CatalogNICommand(catalogNIRepository.findById(id).get());
        CatalogNICommand res= new CatalogNICommand();
        if (catalogFactorInsecurity.isDeleted() == false) {
            res = catalogFactorInsecurity;
        }
        return res;

    }
    @Override
    public CatalogNI CreateCatalogNI(CatalogNICommand catalogNICommand)
    {
        CatalogNI catalogNI1=new CatalogNI();
        catalogNI1 = catalogNIRepository.save(catalogNICommand.toDomain());
        return catalogNI1;
    }
    @Override
    public CatalogNI updateCatalogNI(CatalogNICommand catalogFacIns){
        CatalogNI facIns = catalogNIRepository.findById(catalogFacIns.getId()).get();
        facIns.setCatalogNIName(catalogFacIns.getCatalogNIName());
        facIns.setCatalogNIDescription(catalogFacIns.getCatalogNIDescription());
        facIns.setCatalogNICode(catalogFacIns.getCatalogNICode());
        CatalogNI itemPersisted = catalogNIRepository.save(facIns);
        return itemPersisted;
    }
    @Override
    public void deleteIdNI(Long id)
    {
        catalogNIRepository.deleteById(id);

    }
    @Override
    public void desactivateCNI(Long id) {
        CatalogNI catalogNI = catalogNIRepository.findById(id).get();
        catalogNI.setDeleted(true);
        catalogNIRepository.save(catalogNI);
    }

    public List<CatalogNICommand> verificarDelete() {
        List<CatalogNICommand> fiCommands = new ArrayList<>();
        catalogNIRepository.findAll().forEach(catalogNI -> {
            fiCommands.add(new CatalogNICommand(catalogNI));
        });
        List<CatalogNICommand> fiCommandsR = new ArrayList<>();
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
    protected CrudRepository<CatalogNI, Long> getRepository() {
        return null;
    }

}
