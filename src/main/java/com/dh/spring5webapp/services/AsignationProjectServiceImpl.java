package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.AsignationProjectCommand;
import com.dh.spring5webapp.model.AsignationProject;
import com.dh.spring5webapp.repositories.AsignationProjectRepository;
import com.dh.spring5webapp.repositories.EmployeeRepository;
import com.dh.spring5webapp.repositories.ProjectRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AsignationProjectServiceImpl extends GenericServiceImpl<AsignationProject> implements AsignationProjectService {
    private AsignationProjectRepository asignationProjectRepository;
    private EmployeeRepository employeeRepository;
    private ProjectRepository projectRepository;

    public AsignationProjectServiceImpl(AsignationProjectRepository asignationProjectRepository, EmployeeRepository employeeRepository, ProjectRepository projectRepository) {
        this.asignationProjectRepository = asignationProjectRepository;
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public List<AsignationProjectCommand> getAllAsignationProject() {
        List<AsignationProjectCommand> assignationList = new ArrayList<>();
        asignationProjectRepository.findAsig(false).forEach(asignationProject -> {
            assignationList.add(new AsignationProjectCommand(asignationProject));
        });
        return assignationList;
    }

    /*public List<AsignationProjectCommand> verificarDelete() {
        List<AsignationProjectCommand> asignationList = new ArrayList<>();
        asignationProjectRepository.findAll().forEach(asignation -> {
            asignationList.add(new AsignationProjectCommand(asignation));
        });
        List<AsignationProjectCommand> notDeleted = new ArrayList<>();
        int i = 0;
        boolean valor = false;
        while (asignationList.size() > i) {
            valor = asignationList.get(i).isDeleted();
            if (valor == false) {
                notDeleted.add(asignationList.get(i));
            }
            i++;
        }
        return notDeleted;
    }*/

    @Override
    public AsignationProject findByIdNotDeleted(Long id) {
        AsignationProject asignation = asignationProjectRepository.findById(id).get();
        AsignationProject res = new AsignationProject();
        if (asignation.isDeleted() == false) {
            res = asignation;
        }
        return res;
    }

    @Override
    public AsignationProject update(AsignationProject asignationProject) {
        //recupera una una instancia de Affliction dado un id<- model.id
        AsignationProject asignationBD = asignationProjectRepository.findById(asignationProject.getId()).get();
        //Settear los atributos en la instancia recuperada
        asignationBD.setAsignationInitDate(asignationProject.getAsignationInitDate());
        asignationBD.setAsingationEndDate(asignationProject.getAsingationEndDate());
        asignationBD.setEmployee(employeeRepository.findById(asignationProject.getEmployeId()).orElse(null));
        asignationBD.setProject(projectRepository.findById(asignationProject.getProjectId()).orElse(null));
        //guardar la instancia
        AsignationProject asignationPersisted = asignationProjectRepository.save(asignationBD);
        return asignationPersisted;
    }

    @Override
    public AsignationProject create(AsignationProject newAsignationProject) {
        AsignationProject asignationModel = new AsignationProject();
        asignationModel.setEmployee(employeeRepository.findById(newAsignationProject.getEmployeId()).orElse(null));
        asignationModel.setProject(projectRepository.findById(newAsignationProject.getProjectId()).orElse(null));
        AsignationProject asignationPersisted = asignationProjectRepository.save(asignationModel);
        return asignationPersisted;
    }

    @Override
    public void delete(Long id) {
        AsignationProject asignationToDelete = asignationProjectRepository.findById(id).get();
        asignationToDelete.setDeleted(true);
        asignationProjectRepository.save(asignationToDelete);
    }

    @Override
    protected CrudRepository<AsignationProject, Long> getRepository() {
        return asignationProjectRepository;
    }


}

