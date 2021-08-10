package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.AsignationProjectCommand;
import com.dh.spring5webapp.model.AsignationProject;

import java.util.List;

public interface AsignationProjectService extends GenericService<AsignationProject> {
    List<AsignationProjectCommand> getAllAsignationProject();

    AsignationProject findByIdNotDeleted(Long id);

    AsignationProject update(AsignationProject asignationProject);

    AsignationProject create(AsignationProject asignationProject);

    void delete(Long id);
}