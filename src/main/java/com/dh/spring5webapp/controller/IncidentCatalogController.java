package com.dh.spring5webapp.controller;


import com.dh.spring5webapp.command.IncidentCatalogCommand;
import com.dh.spring5webapp.model.IncidentCatalog;
import com.dh.spring5webapp.services.IncidentCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;


@Controller
@Path("/incidentCatalogs")
@Produces("application/json")
@CrossOrigin
public class IncidentCatalogController {
    @Autowired
    private IncidentCatalogService catalogService;


    @GET
    public Response getAllCatalog() {
        List<IncidentCatalogCommand> catalog = catalogService.getAllCatalogs();
        return Response.ok(catalog).build();
    }

    @GET
    @Path("/{id}")
    public Response getCatalogById(@PathParam("id") @NotNull Long id) {
        IncidentCatalog incidentCatalog = catalogService.findByIdNotDeleted(id);
        return Response.ok(new IncidentCatalogCommand(incidentCatalog)).build();
    }

    @POST
    public Response saveCatalog(IncidentCatalogCommand catalogCommand) {
        IncidentCatalog toCreate = catalogCommand.toDomain();
        IncidentCatalog catalogPersisted = catalogService.save(toCreate);
        return Response.ok(new IncidentCatalogCommand(catalogPersisted)).build();
    }

    @PUT
    public Response updateCatalog(IncidentCatalogCommand catalogCommand) {
        IncidentCatalog update = catalogService.update(catalogCommand.toDomain());
        /*Incident update = incidentService.update(incidentCommand.toDomain());*/
        return Response.ok(new IncidentCatalogCommand(update)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCatalog(@PathParam("id") String id) {
        catalogService.delete(Long.valueOf(id));
        return Response.ok().build();
    }

    @OPTIONS
    public Response prefligth() {
        return Response.ok().build();
    }


}
