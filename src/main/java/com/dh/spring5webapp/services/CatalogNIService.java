package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.CatalogFICommand;
import com.dh.spring5webapp.command.CatalogNICommand;
import com.dh.spring5webapp.model.CatalogNI;

import java.util.List;

public interface CatalogNIService extends GenericService<CatalogNI> {
    List<CatalogNICommand> getAllCatalogsNI();

    CatalogNICommand findByIdNI(Long id);

    CatalogNI CreateCatalogNI(CatalogNICommand catalogNICommand);

    CatalogNI updateCatalogNI(CatalogNICommand catalogFacIns);

    void deleteIdNI(Long id);

    void desactivateCNI(Long id);

}