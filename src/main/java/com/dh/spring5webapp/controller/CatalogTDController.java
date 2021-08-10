package com.dh.spring5webapp.controller;
import com.dh.spring5webapp.command.CatalogTDCommand;
import com.dh.spring5webapp.model.CatalogTD;
import com.dh.spring5webapp.services.CatalogTDService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Controller
@Path("/catalogTD")
@Produces(MediaType.APPLICATION_JSON)
@CrossOrigin
public class CatalogTDController {
        private CatalogTDService service;


        public CatalogTDController(CatalogTDService service) {
            this.service = service;

        }
    @GET
    public Response getAllCatalogNIs() {
        List<CatalogTDCommand> catalogFactorInsecurity =service.getAllCatalogsTD();
        return Response.ok(catalogFactorInsecurity).build();
    }
    @GET
    @Path("/{id}")
    public Response getCatalogById(@PathParam("id") @NotNull Long id) {
        CatalogTDCommand catalogTDCommand = service.findByIdTD(id);
        return Response.ok(catalogTDCommand).build();
    }
    @POST
    public CatalogTDCommand addCatalogTD( CatalogTDCommand catalogColan) {
        CatalogTD catalogTd = service.CreateCatalogBI(catalogColan);
        return new CatalogTDCommand(catalogTd);
    }
    @PUT
    public CatalogTDCommand updateCatalogTD(CatalogTDCommand catalogFacIns){
        CatalogTD catalogTd=service.updateCatalogTD(catalogFacIns);
        return new CatalogTDCommand(catalogTd);
    }
    @DELETE
    @Path("/{id}")
    public Response deleteCatalogTd(@PathParam("id") String id) {
        service.deleteIdTD(Long.valueOf(id));
        return Response.ok().build();
    }
    @DELETE
    @Path("/deactivate/{id}")
    public Response desactivarTD(@PathParam("id") String id) {
        service.desactivateCTD(Long.valueOf(id));
        return Response.ok().build();
    }

}
