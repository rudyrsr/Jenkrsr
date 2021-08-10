package com.dh.spring5webapp.controller;


import com.dh.spring5webapp.command.AfflictionCatalogCommand;
import com.dh.spring5webapp.model.AfflictionCatalog;
import com.dh.spring5webapp.services.AfflictionCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;


@Controller
@Path("/afflictionCatalogs")
@Produces("application/json")
@CrossOrigin
public class AfflictionCatalogController {
    @Autowired
    private AfflictionCatalogService catalogService;


    @GET
    public Response getAllCatalog() {
        List<AfflictionCatalogCommand> catalog = catalogService.getAllCatalogs();
        return Response.ok(catalog).build();
    }

    @GET
    @Path("/{id}")
    public Response getCatalogById(@PathParam("id") @NotNull Long id) {
        AfflictionCatalog afflictionCatalog = catalogService.findByIdNotDeleted(id);
        return Response.ok(new AfflictionCatalogCommand(afflictionCatalog)).build();
    }

    @POST
    public Response saveCatalog(AfflictionCatalogCommand catalogCommand) {
        AfflictionCatalog toCreate = catalogCommand.toDomain();
        AfflictionCatalog catalogPersisted = catalogService.save(toCreate);
        return Response.ok(new AfflictionCatalogCommand(catalogPersisted)).build();
    }

    @PUT
    public Response updateCatalog(AfflictionCatalogCommand catalogCommand) {
        AfflictionCatalog update = catalogService.update(catalogCommand.toDomain());
        /*Incident update = incidentService.update(incidentCommand.toDomain());*/
        return Response.ok(new AfflictionCatalogCommand(update)).build();
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
