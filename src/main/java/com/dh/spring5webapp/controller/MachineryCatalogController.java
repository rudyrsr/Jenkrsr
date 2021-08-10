package com.dh.spring5webapp.controller;

import com.dh.spring5webapp.command.MachineryCatalogCommand;
import com.dh.spring5webapp.model.MachineryCatalog;
import com.dh.spring5webapp.services.MachineryCatalogService;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.List;

@Controller
@Path("/machinerycatalog")
@Produces("application/json")
@CrossOrigin

public class MachineryCatalogController {
    private MachineryCatalogService service;

    public MachineryCatalogController(MachineryCatalogService service) {
        this.service = service;
    }

    @GET
    public Response getAllMachine() {
        List<MachineryCatalogCommand> machinerCatalog = service.getAllMachineryCatalog();
        return Response.ok(machinerCatalog).build();
    }

    @GET
    @Path("/{id}")
    public Response getCatalogMachineById(@PathParam("id") @NotNull Long id) {
        MachineryCatalog machineryCatalog = service.findByIdNotDeleted(id);
        return Response.ok(new MachineryCatalogCommand(machineryCatalog)).build();
    }

    @POST
    public MachineryCatalogCommand addMachineCatalog(MachineryCatalogCommand machineryCatalogCommand) {
        MachineryCatalog machineryCatalog = service.save(machineryCatalogCommand.toDomain());
        return new MachineryCatalogCommand(machineryCatalog);
    }

    @PUT
    public Response updateMachineryCatalog(MachineryCatalogCommand machineryCatalogCommand) {
        MachineryCatalog machineryCatalagV = machineryCatalogCommand.toDomain();
        if (service.findByIdB(machineryCatalogCommand.getId()) == true) {
            machineryCatalagV = service.updateMachineryCatalog(machineryCatalogCommand);
        }
        return Response.ok(new MachineryCatalogCommand(machineryCatalagV)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMachineryCatalog(@PathParam("id") String id) {
        service.deleted(Long.valueOf(id));
        return Response.ok().build();
    }

    @OPTIONS
    public Response prefligth() {
        return Response.ok().build();
    }

    @Path("/{id}/image")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadFile(@PathParam("id") String id,
                               @FormDataParam("file") InputStream file,
                               @FormDataParam("file") FormDataContentDisposition fileDisposition) {
        service.saveImage(Long.valueOf(id), file);
        return Response.ok("Data uploaded successfully !!").build();
    }

}