package com.dh.spring5webapp.controller;

import com.dh.spring5webapp.command.AccidentComand;
import com.dh.spring5webapp.model.Accident;
import com.dh.spring5webapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Controller
@Path("/accident")
@Produces(MediaType.APPLICATION_JSON)
@CrossOrigin
public class AccidentController {

    @Autowired
    private AccidentService accidentService;


    @GET
    public Response getAllAccidents() {
        List<AccidentComand> accidents = accidentService.getAllaccidents();
        return Response.ok(accidents).build();
    }

    @GET
    @Path("/{id}")
    public Response getCatalogById(@PathParam("id") @NotNull Long id) {
        AccidentComand accident = accidentService.findByIdA(id);
        return Response.ok(accident).build();
    }
    @GET
    @Path("/find/{id}")
    public Response getfindAccidents(@PathParam("id") @NotNull String id) {
        AccidentComand accidents = accidentService.findCodeAccidents(id);
        return Response.ok(accidents).build();
    }

    @POST
    public Response saveIncident(AccidentComand accidentComand) {
        Accident incidentPersisted = accidentService.CreateAccident(accidentComand);
        return Response.ok(new AccidentComand(incidentPersisted)).build();
    }

    @OPTIONS
    public Response prefligth() {
        return Response.ok().build();
    }

    @PUT
    public Response updateAccident(AccidentComand accidentComand) {
        Accident accidentV = new Accident();
        if (accidentService.findByIdB(accidentComand.getId()) == true) {
            accidentV = accidentService.updateAccident(accidentComand);
        }
        return Response.ok(new AccidentComand(accidentV)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAccident(@PathParam("id") String id) {
        accidentService.deleteAccident(Long.valueOf(id));
        return Response.ok().build();
    }

    @DELETE
    @Path("/deactivate/{id}")
    public Response DesactivarAccident(@PathParam("id") String id) {
        accidentService.desactivateAccident(Long.valueOf(id));
        return Response.ok().build();
    }


}
