package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.AfflictionCatalogCommand;
import com.dh.spring5webapp.model.AfflictionCatalog;
import com.dh.spring5webapp.repositories.AfflictionCatalogRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AfflictionCatalogServiceImpl extends GenericServiceImpl<AfflictionCatalog> implements AfflictionCatalogService {
    private AfflictionCatalogRepository catalogRepository;

    public AfflictionCatalogServiceImpl(AfflictionCatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    protected CrudRepository<AfflictionCatalog, Long> getRepository() {
        return catalogRepository;
    }

    @Override
    public List<AfflictionCatalogCommand> getAllCatalogs() {
        List<AfflictionCatalogCommand> catalogList = new ArrayList<>();
        catalogRepository.findCat(false).forEach(catalog -> {
            catalogList.add(new AfflictionCatalogCommand(catalog));
        });
        return catalogList;
    }

//    public List<AfflictionCatalogCommand> verificarDelete() {
//        List<AfflictionCatalogCommand> catalogList = new ArrayList<>();
//        catalogRepository.findAll().forEach(catalog -> {
//            catalogList.add(new AfflictionCatalogCommand(catalog));
//        });
//        List<AfflictionCatalogCommand> notDeleted = new ArrayList<>();
//        int i = 0;
//        boolean valor = false;
//        while (catalogList.size() > i) {
//            valor = catalogList.get(i).isDeleted();
//            if (valor == false) {
//                notDeleted.add(catalogList.get(i));
//            }
//            i++;
//        }
//        return notDeleted;
//    }

    @Override
    public AfflictionCatalog findByIdNotDeleted(Long id) {
        AfflictionCatalog catalog = catalogRepository.findById(id).get();
        AfflictionCatalog res = new AfflictionCatalog();
        if (catalog.isDeleted() == false) {
            res = catalog;
        }
        return res;
    }

    @Override
    public AfflictionCatalog update(AfflictionCatalog catalogUpdate) {
        //recuperar una instacia de de un catalogo dado un id
        AfflictionCatalog catalogBD = catalogRepository.findById(catalogUpdate.getId()).get();
        //Settear los atributos en la instancia recuperada
        catalogBD.setName(catalogUpdate.getName());
        catalogBD.setCode(catalogUpdate.getCode());
        catalogBD.setDescription(catalogUpdate.getDescription());
        //guardamos la instacia
        AfflictionCatalog catalogPersisted = catalogRepository.save(catalogBD);
        return catalogPersisted;
    }

    @Override
    public void delete(Long id) {
        AfflictionCatalog catalogtodelete = catalogRepository.findById(id).get();
        catalogtodelete.setDeleted(true);
        catalogRepository.save(catalogtodelete);
    }
}

