package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.CatalogTDCommand;
import com.dh.spring5webapp.model.CatalogTD;

import java.util.List;

public interface CatalogTDService extends GenericService<CatalogTD> {

    List<CatalogTDCommand> getAllCatalogsTD();

    CatalogTDCommand findByIdTD(Long id);

    CatalogTD CreateCatalogBI(CatalogTDCommand catalogTD);

    CatalogTD updateCatalogTD(CatalogTDCommand catalogFacIns);

    void desactivateCTD(Long id);

    void deleteIdTD(Long id);
}