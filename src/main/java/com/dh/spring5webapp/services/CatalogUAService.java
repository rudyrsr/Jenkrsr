package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.CatalogUACommand;
import com.dh.spring5webapp.model.CatalogUA;

import java.util.List;

public interface CatalogUAService extends GenericService<CatalogUA> {

    List<CatalogUACommand> getAllCatalogsUA();

    CatalogUACommand findByIdUA(Long id);

    CatalogUA CreateCatalogBI(CatalogUACommand catalogUACommand);

    CatalogUA updateCatalogUA(CatalogUACommand catalog);

    void deleteIdUA(Long id);

    void desactivateCUA(Long id);
}
