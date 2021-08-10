package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.IncidentCatalogCommand;
import com.dh.spring5webapp.model.IncidentCatalog;

import java.util.List;

public interface IncidentCatalogService extends GenericService<IncidentCatalog> {
    List<IncidentCatalogCommand> getAllCatalogs();

    IncidentCatalog findByIdNotDeleted(Long id);

    IncidentCatalog update(IncidentCatalog catalogUpdate);

    void delete(Long id);
}