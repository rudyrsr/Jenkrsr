package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.IncidentCommand;
import com.dh.spring5webapp.model.Incident;

import java.io.InputStream;
import java.util.List;

public interface IncidentService extends GenericService<Incident> {
    void saveImage(Long id, InputStream file);

    List<IncidentCommand> getAllIncidents();

    Incident findByIdNotDeleted(Long id);

    Incident update(Incident incidentUpdate);

    void delete(Long id);
}