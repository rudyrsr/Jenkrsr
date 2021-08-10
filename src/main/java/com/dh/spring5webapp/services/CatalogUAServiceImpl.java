package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.CatalogUACommand;
import com.dh.spring5webapp.model.CatalogUA;
import com.dh.spring5webapp.repositories.CatalogUARepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogUAServiceImpl extends GenericServiceImpl<CatalogUA> implements CatalogUAService {
    private CatalogUARepository catalogUARepository;

    public CatalogUAServiceImpl(CatalogUARepository catalogRepository) {
        this.catalogUARepository = catalogRepository;
    }

    @Override
    public List<CatalogUACommand> getAllCatalogsUA() {
        List<CatalogUACommand> catalogList = verificarDelete();
        return catalogList;
    }

    @Override
    public CatalogUACommand findByIdUA(Long id)
    {
        CatalogUACommand catalogFactorInsecurity = new CatalogUACommand(catalogUARepository.findById(id).get());
        CatalogUACommand res= new CatalogUACommand();
        if (catalogFactorInsecurity.isDeleted() == false) {
            res = catalogFactorInsecurity;
        }
        return res;

    }
    public CatalogUA CreateCatalogBI(CatalogUACommand catalogUACommand)
    {
        CatalogUA catalogUA1=new CatalogUA();
        catalogUA1 = catalogUARepository.save(catalogUACommand.toDomain());
        return catalogUA1;
    }
    public CatalogUA updateCatalogUA(CatalogUACommand catalog){
        CatalogUA catalog1 = catalogUARepository.findById(catalog.getId()).get();
        catalog1.setCatalogUACode(catalog.getCatalogUACode());
        catalog1.setCatalogUAName(catalog.getCatalogUAName());
        catalog1.setCatalogUADescription(catalog.getCatalogUADescription());
        CatalogUA itemPersisted = catalogUARepository.save(catalog1);
        return itemPersisted;
    }
    @Override
    public void deleteIdUA(Long id)
    {
        catalogUARepository.deleteById(id);

    }
    @Override
    public void desactivateCUA(Long id) {
        CatalogUA catalogUA = catalogUARepository.findById(id).get();
        catalogUA.setDeleted(true);
        catalogUARepository.save(catalogUA);
    }

    public List<CatalogUACommand> verificarDelete() {
        List<CatalogUACommand> fiCommands = new ArrayList<>();
        catalogUARepository.findAll().forEach(catalogUA -> {
            fiCommands.add(new CatalogUACommand(catalogUA));
        });
        List<CatalogUACommand> fiCommandsR = new ArrayList<>();
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
    protected CrudRepository<CatalogUA, Long> getRepository() {
        return catalogUARepository;
    }



}
