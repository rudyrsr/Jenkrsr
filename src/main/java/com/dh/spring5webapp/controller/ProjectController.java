package com.dh.spring5webapp.controller;


import com.dh.spring5webapp.command.ProjectCommand;
import com.dh.spring5webapp.model.Project;
import com.dh.spring5webapp.services.AsignationProjectService;
import com.dh.spring5webapp.services.ProjectService;
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
@Path("/projects")
@Produces("application/json")
@CrossOrigin
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private AsignationProjectService asignationProjectService;


    @GET
    public Response getAllProjects() {
        List<ProjectCommand> projectCommandList = projectService.getAllProjects();
        return Response.ok(projectCommandList).build();
    }

    @GET
    @Path("/{id}")
    public Response getProjectById(@PathParam("id") @NotNull Long id) {
        Project project = projectService.findByIdNotDeleted(id);
        return Response.ok(new ProjectCommand(project)).build();
    }

    @POST
    public Response saveProject(ProjectCommand projectCommand) {
        Project projectModel = projectCommand.toDomain();
        Project projectPersisted = projectService.save(projectModel);
        return Response.ok(new ProjectCommand(projectPersisted)).build();
    }

    @PUT
    public Response updateProject(ProjectCommand projectCommand) {
        Project toUpdate = projectService.update(projectCommand.toDomain());
        return Response.ok(new ProjectCommand(toUpdate)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProject(@PathParam("id") String id) {
        projectService.delete(Long.valueOf(id));
        return Response.ok().build();
    }

    @OPTIONS
    public Response projectPrefligth() {
        return Response.ok().build();
    }


    @Path("/{id}/image")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadFile(@PathParam("id") String id,
                               @FormDataParam("file") InputStream file,
                               @FormDataParam("file") FormDataContentDisposition fileDisposition) {
        projectService.saveImage(Long.valueOf(id), file);
        return Response.ok("Data uploaded successfully !!").build();
    }

}
