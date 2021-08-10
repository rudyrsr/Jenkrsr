package com.dh.spring5webapp.controller;

import com.dh.spring5webapp.command.CatalogUACommand;
import com.dh.spring5webapp.model.CatalogUA;
import com.dh.spring5webapp.services.CatalogUAService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Controller
@Path("/catalogUA")
@Produces(MediaType.APPLICATION_JSON)
@CrossOrigin
public class CatalogUAController {

    private CatalogUAService service;

    public CatalogUAController(CatalogUAService service) {
        this.service = service;

    }
    @GET
    public Response getAllCatalogUAs() {
        List<CatalogUACommand> catalogFactorInsecurity =service.getAllCatalogsUA();
        return Response.ok(catalogFactorInsecurity).build();
    }
    @GET
    @Path("/{id}")
    public Response getCatalogById(@PathParam("id") @NotNull Long id) {
        CatalogUACommand catalogUACommand = service.findByIdUA(id);
        return Response.ok(catalogUACommand).build();
    }
    @POST
    public CatalogUACommand addCatalogNI( CatalogUACommand catalogColan) {
        CatalogUA catalogUa = service.CreateCatalogBI(catalogColan);
        return new CatalogUACommand(catalogUa);
    }
    @PUT
    public CatalogUACommand updateCatalogNI(CatalogUACommand catalogFacIns){
        CatalogUA catalogUa=service.updateCatalogUA(catalogFacIns);
        return new CatalogUACommand(catalogUa);
    }
    @DELETE
    @Path("/{id}")
    public Response deleteCatalogUA(@PathParam("id") String id) {
        service.deleteIdUA(Long.valueOf(id));
        return Response.ok().build();
    }
    @DELETE
    @Path("/deactivate/{id}")
    public Response DesactivarUa(@PathParam("id") String id) {
        service.desactivateCUA(Long.valueOf(id));
        return Response.ok().build();
    }


}

