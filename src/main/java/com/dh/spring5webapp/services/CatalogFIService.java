package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.CatalogFICommand;
import com.dh.spring5webapp.model.CatalogFI;

import java.util.List;

public interface CatalogFIService extends GenericService<CatalogFI> {
    List<CatalogFICommand> getAllCatalogsFI();

    CatalogFICommand findByIdFI(Long id);

    CatalogFI CreateCatalogBI(CatalogFICommand catalogFI);

    CatalogFI updateCatalogFI(CatalogFICommand catalogFacIns);

    void deleteIdFI(Long id);

    void desactivateCFI(Long id);

}