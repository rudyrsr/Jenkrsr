package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.AfflictionCatalogCommand;
import com.dh.spring5webapp.model.AfflictionCatalog;

import java.util.List;

public interface AfflictionCatalogService extends GenericService<AfflictionCatalog> {
    List<AfflictionCatalogCommand> getAllCatalogs();

    AfflictionCatalog findByIdNotDeleted(Long id);

    AfflictionCatalog update(AfflictionCatalog catalogUpdate);

    void delete(Long id);

}