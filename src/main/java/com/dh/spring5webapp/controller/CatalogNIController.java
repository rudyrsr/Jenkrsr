package com.dh.spring5webapp.controller;

import com.dh.spring5webapp.command.CatalogFICommand;
import com.dh.spring5webapp.command.CatalogNICommand;
import com.dh.spring5webapp.model.CatalogFI;
import com.dh.spring5webapp.model.CatalogNI;
import com.dh.spring5webapp.services.CatalogFIService;
import com.dh.spring5webapp.services.CatalogNIService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Controller
@Path("/catalogNI")
@Produces(MediaType.APPLICATION_JSON)
@CrossOrigin
public class CatalogNIController {
        private CatalogNIService service;


        public CatalogNIController(CatalogNIService service) {
            this.service = service;

        }
    @GET
    public Response getAllCatalogNIs() {
        List<CatalogNICommand> catalogFactorInsecurity =service.getAllCatalogsNI();
        return Response.ok(catalogFactorInsecurity).build();
    }
    @GET
    @Path("/{id}")
    public Response getCatalogById(@PathParam("id") @NotNull Long id) {
        CatalogNICommand catalogNICommand = service.findByIdNI(id);
        return Response.ok(catalogNICommand).build();
    }
    @POST
    public CatalogNICommand addCatalogNI( CatalogNICommand catalogColan) {
        CatalogNI catalogFi = service.CreateCatalogNI(catalogColan);
        return new CatalogNICommand(catalogFi);
    }
    @PUT
    public CatalogNICommand updateCatalogNI(CatalogNICommand catalogFacIns){
        CatalogNI catalogNi=service.updateCatalogNI(catalogFacIns);
        return new CatalogNICommand(catalogNi);
    }
    @DELETE
    @Path("/{id}")
    public Response deleteCatalogNI(@PathParam("id") String id) {
        service.deleteIdNI(Long.valueOf(id));
        return Response.ok().build();
    }
    @DELETE
    @Path("/deactivate/{id}")
    public Response DesactivarNI(@PathParam("id") String id) {
        service.desactivateCNI(Long.valueOf(id));
        return Response.ok().build();
    }

}
