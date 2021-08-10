package com.dh.spring5webapp.controller;

import com.dh.spring5webapp.command.MachineryCalendaryCommand;
import com.dh.spring5webapp.command.MachineryCommand;
import com.dh.spring5webapp.model.Machinery;
import com.dh.spring5webapp.services.MachineryCatalogService;
import com.dh.spring5webapp.services.MachineryService;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.List;

@Controller
@Produces("application/json")
@Path("/machinery")
@CrossOrigin
public class MachineryController {
    @Autowired
    private MachineryService service;
    @Autowired
    private MachineryCatalogService catalogService;


    @GET
    public Response getAllMachine() {
        List<MachineryCommand> machine = service.getAllMachine();
        return Response.ok(machine).build();
    }

    @GET
    @Path("/{id}")
    public Response getMachineById(@PathParam("id") @NotNull Long id) {
        Machinery machinery = service.findByIdNotDeleted(id);
        return Response.ok(new MachineryCommand(machinery)).build();
    }

    @GET
    @Path("/ms/{id}")
    public Response getMachineryR(@PathParam("id") @NotNull Long id) {
        List<MachineryCommand> machine = service.MachineryMes(id);
        return Response.ok(machine).build();

    }

    @GET
    @Path("/mss/")
    public Response getMounth() {
        List<MachineryCalendaryCommand> mounths = service.getMounth();
        return Response.ok(mounths).build();
    }

    @GET
    @Path("/an/{id}")
    public Response getAllIncidentsA(@PathParam("id") @NotNull Long id) {
        List<MachineryCommand> accidents = service.MachineryYear(id);
        return Response.ok(accidents).build();
    }

    @POST
    public Response saveMachine(MachineryCommand machineryCommand) {
        Machinery model = machineryCommand.toDomain();
        model.setMachineryCatalog(catalogService.findById(machineryCommand.getMachineryCatalogId()));
        model = service.save(model);
        return Response.ok(new MachineryCommand(model)).build();
    }

    @PUT
    public Response updateMachinery(MachineryCommand machineryCommand) {
        Machinery machineryV = machineryCommand.toDomain();
        if (service.findByIdB(machineryCommand.getId()) == true) {
            machineryV = service.updateMachinery(machineryCommand);
        }
        return Response.ok(new MachineryCommand(machineryV)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMachinery(@PathParam("id") String id) {
        service.delete(Long.valueOf(id));
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
