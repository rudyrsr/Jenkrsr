package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.IncidentCatalogCommand;
import com.dh.spring5webapp.model.IncidentCatalog;
import com.dh.spring5webapp.repositories.IncidentCatalogRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncidentCatalogServiceImpl extends GenericServiceImpl<IncidentCatalog> implements IncidentCatalogService {
    private IncidentCatalogRepository catalogRepository;

    public IncidentCatalogServiceImpl(IncidentCatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    protected CrudRepository<IncidentCatalog, Long> getRepository() {
        return catalogRepository;
    }

    @Override
    public List<IncidentCatalogCommand> getAllCatalogs() {
        List<IncidentCatalogCommand> catalogList = new ArrayList<>();
        catalogRepository.findCat(false).forEach(catalog ->{
            catalogList.add(new IncidentCatalogCommand(catalog));
        });
        return catalogList;
    }

    /*public List<IncidentCatalogCommand> verificarDelete() {
        List<IncidentCatalogCommand> catalogList = new ArrayList<>();
        catalogRepository.findAll().forEach(catalog -> {
            catalogList.add(new IncidentCatalogCommand(catalog));
        });
        List<IncidentCatalogCommand> notDeleted = new ArrayList<>();
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
    }*/

    @Override
    public IncidentCatalog findByIdNotDeleted(Long id) {
        IncidentCatalog catalog = catalogRepository.findById(id).get();
        IncidentCatalog res = new IncidentCatalog();
        if (catalog.isDeleted() == false) {
            res = catalog;
        }
        return res;
    }

    @Override
    public IncidentCatalog update(IncidentCatalog catalogUpdate) {
        //recuperar una instacia de de un catalogo dado un id
        IncidentCatalog catalogBD = catalogRepository.findById(catalogUpdate.getId()).get();
        /*Incident incidentBD = incidentRepository.findById(incidentUpdate.getId()).get();*/
        //Settear los atributos en la instancia recuperada
        catalogBD.setName(catalogUpdate.getName());
        catalogBD.setCode(catalogUpdate.getCode());
        catalogBD.setDescription(catalogUpdate.getDescription());
        //guardamos la instacia
        IncidentCatalog catalogPersisted = catalogRepository.save(catalogBD);
        return catalogPersisted;
    }

    @Override
    public void delete(Long id) {
        IncidentCatalog catalogToDelete = catalogRepository.findById(id).get();

        catalogToDelete.setDeleted(true);

        catalogRepository.save(catalogToDelete);
    }

}

