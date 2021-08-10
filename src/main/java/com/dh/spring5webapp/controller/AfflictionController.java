package com.dh.spring5webapp.controller;


import com.dh.spring5webapp.command.AfflictionCommand;
import com.dh.spring5webapp.model.Affliction;
import com.dh.spring5webapp.services.AfflictionCatalogService;
import com.dh.spring5webapp.services.AfflictionService;
import com.dh.spring5webapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;


@Controller
@Path("/afflictions")
@Produces("application/json")
@CrossOrigin
public class AfflictionController {
    @Autowired
    private AfflictionService afflictionService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AfflictionCatalogService catalogService;

    @GET
    public Response getAllAfflictions() {
        List<AfflictionCommand> afflictions = afflictionService.getAllAfflictions();
        return Response.ok(afflictions).build();
    }

    @GET
    @Path("/{id}")
    public Response getAfflictionById(@PathParam("id") @NotNull Long id) {
        Affliction affliction = afflictionService.findByIdNotDeleted(id);
        return Response.ok(new AfflictionCommand(affliction)).build();
    }

    @POST
    public Response saveAffliction(AfflictionCommand afflictionCommand) {
        Affliction toCreate = afflictionCommand.toDomain();
        toCreate.setEmployee(employeeService.findById(afflictionCommand.getEmployeeId()));
        toCreate.setAfflictionCatalog(catalogService.findById(afflictionCommand.getAfflictionCatalogId()));
        Affliction afflictionPersisted = afflictionService.save(toCreate);
        return Response.ok(new AfflictionCommand(afflictionPersisted)).build();
    }

    @PUT
    public Response updateAffliction(AfflictionCommand afflictionCommand) {
        Affliction toUpdate = afflictionService.update(afflictionCommand.toDomain());
        return Response.ok(new AfflictionCommand(toUpdate)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAffliction(@PathParam("id") String id) {
        afflictionService.delete(Long.valueOf(id));
        return Response.ok().build();
    }

    @OPTIONS
    public Response prefligth() {
        return Response.ok().build();
    }

}
