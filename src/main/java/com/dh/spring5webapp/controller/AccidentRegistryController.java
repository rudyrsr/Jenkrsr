package com.dh.spring5webapp.controller;

import com.dh.spring5webapp.command.AccidentRegistryComand;
import com.dh.spring5webapp.command.CalendaryCommand;
import com.dh.spring5webapp.model.AccidentRegistry;
import com.dh.spring5webapp.services.AccidentRegitryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Controller
@Path("/accidentR")
@Produces(MediaType.APPLICATION_JSON)
@CrossOrigin
public class AccidentRegistryController {
    @Autowired
    private AccidentRegitryService accidentRegitryService;

    @GET
    public Response getAllIncidents() {
        List<AccidentRegistryComand> accidents = accidentRegitryService.getAllaccidents();
        return Response.ok(accidents).build();
    }
    @GET
    @Path("/ms/{id}&{anio}")
    public Response getAllIncidentsM(@PathParam("id") Long id, @PathParam("anio") Long anio ) {
        List<AccidentRegistryComand> accidents = accidentRegitryService.AccidentMes(id,anio);
        return Response.ok(accidents).build();
    }
    @GET
    @Path("/mss/")
    public Response getMounth() {
        List<CalendaryCommand> mounths = accidentRegitryService.getMounthss();
        return Response.ok(mounths).build();
    }
    @GET
    @Path("/an/{id}")
    public Response getAllIncidentsA(@PathParam("id") @NotNull Long id) {
        List<AccidentRegistryComand> accidents = accidentRegitryService.AccidentYear(id);
        return Response.ok(accidents).build();
    }

    @GET
    @Path("/{id}")
    public Response getRegAccidentById(@PathParam("id") @NotNull Long id) {
        AccidentRegistryComand accident = accidentRegitryService.findByIdRA(id);
        return Response.ok(accident).build();
    }
    @POST
    public Response CreateRegAccident(AccidentRegistryComand accidentComand) {
        AccidentRegistry incidentPersisted = accidentRegitryService.createRegistryA(accidentComand);
        if (incidentPersisted.getId() == null)
            return Response.serverError().build();
        else

        {
            return Response.ok(new AccidentRegistryComand(incidentPersisted)).build();
        }

    }
    @PUT
    public Response updateRegAccident(AccidentRegistryComand accidentComand) {
        AccidentRegistry accidentV = accidentRegitryService.updateRegistyA(accidentComand);
        return Response.ok(new AccidentRegistryComand(accidentV)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteRAccident(@PathParam("id") String id) {
        accidentRegitryService.deleteAccident(Long.valueOf(id));
        return Response.ok().build();
    }

    @DELETE
    @Path("/deactivateR/{id}")
    public Response DesactivarAccidentR(@PathParam("id") String id) {
        accidentRegitryService.desactivateAccidentR(Long.valueOf(id));
        return Response.ok().build();
    }
}
