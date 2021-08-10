package com.dh.spring5webapp.controller;

import com.dh.spring5webapp.command.CatalogUCCommand;
import com.dh.spring5webapp.model.CatalogUC;
import com.dh.spring5webapp.services.CatalogUCService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Controller
@Path("/catalogUC")
@Produces(MediaType.APPLICATION_JSON)
@CrossOrigin
public class CatalogUCController {

    private CatalogUCService service;

    public CatalogUCController(CatalogUCService service) {
        this.service = service;

    }
    @GET
    public Response getAllCatalogUAs() {
        List<CatalogUCCommand> catalogFactorInsecurity =service.getAllCatalogsUC();
        return Response.ok(catalogFactorInsecurity).build();
    }
    @GET
    @Path("/{id}")
    public Response getCatalogById(@PathParam("id") @NotNull Long id) {
        CatalogUCCommand catalogUCCommand = service.findByIdUC(id);
        return Response.ok(catalogUCCommand).build();
    }
    @POST
    public CatalogUCCommand addCatalogUC( CatalogUCCommand catalogColan) {
        CatalogUC catalogUa = service.CreateCatalogUC(catalogColan);
        return new CatalogUCCommand(catalogUa);
    }
    @PUT
    public CatalogUCCommand updateCatalogUC(CatalogUCCommand catalogFacIns){
        CatalogUC catalogUc=service.updateCatalogUC(catalogFacIns);
        return new CatalogUCCommand(catalogUc);
    }
    @DELETE
    @Path("/{id}")
    public Response deleteCatalogUC(@PathParam("id") String id) {
        service.deleteIdUC(Long.valueOf(id));
        return Response.ok().build();
    }
    @DELETE
    @Path("/deactivate/{id}")
    public Response DesactivarUc(@PathParam("id") String id) {
        service.desactivateCUC(Long.valueOf(id));
        return Response.ok().build();
    }



}

