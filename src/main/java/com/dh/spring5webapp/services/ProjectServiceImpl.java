package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.AsignationProjectCommand;
import com.dh.spring5webapp.command.ProjectCommand;
import com.dh.spring5webapp.model.Project;
import com.dh.spring5webapp.repositories.AsignationProjectRepository;
import com.dh.spring5webapp.repositories.EmployeeRepository;
import com.dh.spring5webapp.repositories.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl extends GenericServiceImpl<Project> implements ProjectService {
    private static Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);
    private ProjectRepository projectRepository;
    private AsignationProjectRepository asignationRepository;
    private EmployeeRepository employeeRepository;

    public ProjectServiceImpl(ProjectRepository repository) {
        this.projectRepository = repository;
    }

    @Override
    public List<ProjectCommand> getAllProjects() {
        List<ProjectCommand> projectList = new ArrayList<>();
        projectRepository.findProj(false).forEach(project -> {
            projectList.add(new ProjectCommand(project));
        });
        return projectList;
    }

    /*public List<ProjectCommand> verificarDelete() {
        List<ProjectCommand> projectList = new ArrayList<>();
        List<AsignationProjectCommand> asignationList = new ArrayList<>();
        projectRepository.findAll().forEach(project -> {
            projectList.add(new ProjectCommand(project));
        });
        List<ProjectCommand> notDeleted = new ArrayList<>();
        int i = 0;
        boolean valor = false;
        while (projectList.size() > i) {
            valor = projectList.get(i).isDeleted();
            if (valor == false) {
                notDeleted.add(projectList.get(i));
            }
            i++;
        }
        return notDeleted;
    }*/

    @Override
    public Project findByIdNotDeleted(Long id) {
        Project project = projectRepository.findById(id).get();
        Project res = new Project();
        if (project.isDeleted() == false) {
            res = project;
        }
        return res;
    }

    @Override
    public Project update(Project projectUpdate) {
        //recupera una una instancia de Project dado un id<- model.id
        Project projectBD = projectRepository.findById(projectUpdate.getId()).get();
        //Settear los atributos en la instancia recuperada
        projectBD.setName(projectUpdate.getName());
        projectBD.setCode(projectUpdate.getCode());
        projectBD.setDescription(projectUpdate.getDescription());
        projectBD.setLocation(projectUpdate.getLocation());
        projectBD.setInitDate(projectUpdate.getInitDate());
        projectBD.setEndDate(projectUpdate.getEndDate());
        projectBD.setActivate(projectUpdate.isActivate());
        //projectBD.set(employeeRepository.findById(afflictionUpdate.getEmployeeId()).orElse(null));
        //projectBD.setAsignationProjectList(projectUpdate.getAsignationProjectList());
        //projectBD.setAsignationProjectList(asignationRepository.findById(projectUpdate.getAsignationProjectId()).orElse(null));
        projectBD.setImage(projectUpdate.getImage());
        //guardar la instancia
        Project projectPersisted = projectRepository.save(projectBD);
        return projectPersisted;
    }

    @Override
    public void delete(Long id) {
        Project proyectToDelete = projectRepository.findById(id).get();
        proyectToDelete.setDeleted(true);
        projectRepository.save(proyectToDelete);
    }

    @Override
    protected CrudRepository<Project, Long> getRepository() {
        return projectRepository;
    }

    @Override
    public void saveImage(Long id, InputStream file) {
        Project projectPersisted = findById(id);
        try {
            Byte[] bytes = ImageUtils.inputStreamToByteArray(file);
            projectPersisted.setImage(bytes);
            getRepository().save(projectPersisted);
        } catch (IOException e) {
            logger.error("Error reading file", e);
            e.printStackTrace();
        }
    }

}

