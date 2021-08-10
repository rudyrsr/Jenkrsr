package com.dh.spring5webapp.controller;


import com.dh.spring5webapp.command.IncidentCommand;
import com.dh.spring5webapp.model.Incident;
import com.dh.spring5webapp.services.EmployeeService;
import com.dh.spring5webapp.services.IncidentCatalogService;
import com.dh.spring5webapp.services.IncidentService;
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
@Path("/incidents")
@Produces("application/json")
@CrossOrigin
public class IncidentController {
    @Autowired
    private IncidentService incidentService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private IncidentCatalogService catalogService;

    @GET
    public Response getAllIncidents() {
        List<IncidentCommand> incidents = incidentService.getAllIncidents();
        return Response.ok(incidents).build();
    }

    @GET
    @Path("/{id}")
    public Response getIncidentById(@PathParam("id") @NotNull Long id) {
        Incident incident = incidentService.findByIdNotDeleted(id);
        return Response.ok(new IncidentCommand(incident)).build();
    }

    @POST
    public Response saveIncident(IncidentCommand incident) {
        Incident model = incident.toDomain();
        model.setEmployee(employeeService.findById(incident.getEmployeeId()));
        model.setIncidentCatalog(catalogService.findById(incident.getInicentCatalogId()));
        Incident incidentPersisted = incidentService.save(model);
        return Response.ok(new IncidentCommand(incidentPersisted)).build();
    }

    @PUT
    public Response updateIncident(IncidentCommand incidentCommand) {
        Incident update = incidentService.update(incidentCommand.toDomain());
        return Response.ok(new IncidentCommand(update)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteIncident(@PathParam("id") String id) {
        incidentService.delete(Long.valueOf(id));
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
        incidentService.saveImage(Long.valueOf(id), file);
        return Response.ok("Data uploaded successfully !!").build();
    }

}
