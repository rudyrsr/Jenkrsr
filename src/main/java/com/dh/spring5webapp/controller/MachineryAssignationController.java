package com.dh.spring5webapp.controller;


import com.dh.spring5webapp.command.MachineryAssignationCommand;
import com.dh.spring5webapp.model.MachineryAssignation;
import com.dh.spring5webapp.services.EmployeeService;
import com.dh.spring5webapp.services.MachineryAssignationService;
import com.dh.spring5webapp.services.MachineryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Controller
@Path("/MachineryAssignation")
@Produces("application/json")
public class MachineryAssignationController {
    @Autowired
    private MachineryAssignationService service;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private MachineryService machineryService;


    @GET
    public Response getMachineryAssignations() {
        List<MachineryAssignationCommand> machineryAssignationCommands = new ArrayList<>();
        service.findAll().forEach(machineryAssignation -> {
            MachineryAssignationCommand machineryAssignationCommand = new MachineryAssignationCommand(machineryAssignation);
            machineryAssignationCommands.add(machineryAssignationCommand);
        });
        return Response.ok(machineryAssignationCommands).build();
    }

    @GET
    @Path("/{id}")
    public Response getMachineryAssignationById(@PathParam("id") @NotNull Long id) {
    /*{
        if(service.findById(id) == null)
        {
            NotFoundException notfound= new NotFoundException("ID not Found" + id);
            return Response.serverError().entity(notfound).build();
        }
        else {
            MachineryAssignation machineryAssignation = service.findById(id);
            return Response.ok(new MachineryAssignationCommand(machineryAssignation)).build();
        }
    }*/
        MachineryAssignation machineryAssignation = service.findByIdNotDeleted(id);
        return Response.ok(new MachineryAssignationCommand(machineryAssignation)).build();
    }

    @POST
    public Response saveMachineryAssignation(MachineryAssignationCommand machineryAssignationCommand) {
        MachineryAssignation model = machineryAssignationCommand.toDomain();
        model.setEmployee(employeeService.findById(machineryAssignationCommand.getEmployeeId()));
        model.setMachinery(machineryService.findById(machineryAssignationCommand.getMachineryId()));
        MachineryAssignation machineryAssignationPersisted = service.save(model);
        return Response.ok(new MachineryAssignationCommand(machineryAssignationPersisted)).build();
    }

    @PUT
    public Response updateMachineryAssignation(MachineryAssignationCommand machineryAssignationCommand)
    {
        MachineryAssignation toUpadte = service.update(machineryAssignationCommand.toDomain());
        return Response.ok(new MachineryAssignationCommand(toUpadte)).build();

    }

    @DELETE
    @Path("/{id}")
    public Response deleteMachineryAssignationById(@PathParam("id") Long id)
    {
        service.deleteById(Long.valueOf(id));
        return Response.ok().build();
    }

}