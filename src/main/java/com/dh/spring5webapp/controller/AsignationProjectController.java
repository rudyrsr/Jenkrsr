package com.dh.spring5webapp.controller;


import com.dh.spring5webapp.command.AsignationProjectCommand;
import com.dh.spring5webapp.model.AsignationProject;
import com.dh.spring5webapp.services.AsignationProjectService;
import com.dh.spring5webapp.services.EmployeeService;
import com.dh.spring5webapp.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;


@Controller
@Path("/asignationProject")
@Produces("application/json")
@CrossOrigin
public class AsignationProjectController {
    @Autowired
    private AsignationProjectService asignationService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ProjectService projectService;

    @GET
    public Response getAllAsignations() {
        List<AsignationProjectCommand> asignationList = asignationService.getAllAsignationProject();
        return Response.ok(asignationList).build();
    }

    @GET
    @Path("/{id}")
    public Response getAsignationById(@PathParam("id") @NotNull Long id) {
        AsignationProject asignation = asignationService.findByIdNotDeleted(id);
        return Response.ok(new AsignationProjectCommand(asignation)).build();
    }

    @POST
    public Response saveAsignationProject(AsignationProjectCommand asignationCommand) {
        AsignationProject asignationModel = asignationCommand.toDomain();
        asignationModel.setEmployee(employeeService.findById(asignationCommand.getEmployeeId()));
        asignationModel.setProject(projectService.findById(asignationCommand.getProjectId()));
        AsignationProject asignationPersisted = asignationService.save(asignationModel);
        return Response.ok(new AsignationProjectCommand(asignationPersisted)).build();
    }
    /*@POST
    public Response saveAsignationProject(AsignationProjectCommand asignationCommand) {
        AsignationProject toCreate = asignationService.create(asignationCommand.toDomain());
        return Response.ok(new AsignationProjectCommand(toCreate)).build();
    }*/

    @PUT
    public Response updateAsignationProject(AsignationProjectCommand asignationCommand) {
        AsignationProject toUpdate = asignationService.update(asignationCommand.toDomain());
        return Response.ok(new AsignationProjectCommand(toUpdate)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAsignation(@PathParam("id") String id) {
        asignationService.deleteById(Long.valueOf(id));
        return Response.ok().build();
    }

    @OPTIONS
    public Response projectPrefligth() {
        return Response.ok().build();
    }

}
