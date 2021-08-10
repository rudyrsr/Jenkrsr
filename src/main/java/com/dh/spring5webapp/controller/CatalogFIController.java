package com.dh.spring5webapp.controller;

import com.dh.spring5webapp.command.CatalogFICommand;
import com.dh.spring5webapp.model.CatalogFI;
import com.dh.spring5webapp.services.CatalogFIService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Controller
@Path("/catalogFI")
@Produces(MediaType.APPLICATION_JSON)
@CrossOrigin
public class CatalogFIController{
        private CatalogFIService service;


        public CatalogFIController(CatalogFIService service) {
            this.service = service;

        }
    @GET
    public Response getAllCatalogFIs() {
        List<CatalogFICommand> catalogFactorInsecurity =service.getAllCatalogsFI();
        return Response.ok(catalogFactorInsecurity).build();
    }
    @GET
    @Path("/{id}")
    public Response getCatalogById(@PathParam("id") @NotNull Long id) {
         CatalogFICommand catalogFICommand = service.findByIdFI(id);
        return Response.ok(catalogFICommand).build();
    }
    @POST
    public CatalogFICommand addCatalogFI( CatalogFICommand catalogColan) {
        CatalogFI catalogFi = service.CreateCatalogBI(catalogColan);
        return new CatalogFICommand(catalogFi);
    }
    @PUT
    public CatalogFICommand updateCatalogFI(CatalogFICommand catalogFacIns){
          CatalogFI catalogFi=service.updateCatalogFI(catalogFacIns);
        return new CatalogFICommand(catalogFi);
    }
    @DELETE
    @Path("/{id}")
    public Response deleteCatalogFI(@PathParam("id") String id) {
        service.deleteIdFI(Long.valueOf(id));
        return Response.ok().build();
    }
    @DELETE
    @Path("/deactivate/{id}")
    public Response DesactivarFI(@PathParam("id") String id) {
        service.desactivateCFI(Long.valueOf(id));
        return Response.ok().build();
    }


}
