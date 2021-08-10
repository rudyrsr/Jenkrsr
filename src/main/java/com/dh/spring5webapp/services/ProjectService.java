package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.ProjectCommand;
import com.dh.spring5webapp.model.Project;

import java.io.InputStream;
import java.util.List;

public interface ProjectService extends GenericService<Project> {
    void delete(Long id);

    void saveImage(Long id, InputStream file);

    List<ProjectCommand> getAllProjects();

    Project findByIdNotDeleted(Long id);

    Project update(Project projectUpdate);

}