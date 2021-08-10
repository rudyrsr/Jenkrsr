package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.CatalogUCCommand;
import com.dh.spring5webapp.model.CatalogUC;

import java.util.List;

public interface CatalogUCService extends GenericService<CatalogUC> {
    List<CatalogUCCommand> getAllCatalogsUC();
    CatalogUCCommand findByIdUC(Long id);
    CatalogUC CreateCatalogUC(CatalogUCCommand catalogUCCommand);
    CatalogUC updateCatalogUC(CatalogUCCommand catalog);
    void deleteIdUC(Long id);
    void desactivateCUC(Long id);
}
