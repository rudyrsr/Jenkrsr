package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.MachineryCatalogCommand;
import com.dh.spring5webapp.model.MachineryCatalog;

import java.io.InputStream;
import java.util.List;

public interface MachineryCatalogService extends GenericService<MachineryCatalog> {
    void saveImage(Long id, InputStream file);

    MachineryCatalog findByIdNotDeleted(Long id);

    MachineryCatalog updateMachineryCatalog(MachineryCatalogCommand machineryCatalog);

    List<MachineryCatalogCommand> getAllMachineryCatalog();

    void deleted(Long id);
}
