package com.dh.spring5webapp.controller;


import com.dh.spring5webapp.command.PositionCommand;
import com.dh.spring5webapp.model.Position;
import com.dh.spring5webapp.services.PositionService;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Controller
@Path("/positions")
@Produces("application/json")

public class PositionController {
    private PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GET
    public Response getPositions()
    {
        List<PositionCommand> positionCommandList = positionService.getAllPositions();
        return Response.ok(positionCommandList).build();
    }

    @GET
    @Path("/{id}")
    public Response getPositionById(@PathParam("id")Long id)
    {
        if(positionService.findById(id) == null)
        {
            NotFoundException notfound= new NotFoundException("ID not Found" + id);
            return Response.serverError().entity(notfound).build();
        }
        else {
            Position position = positionService.findById(id);
            return Response.ok(new PositionCommand(position)).build();
        }
    }
    @POST
    public Response savePosition(PositionCommand positionCommand)
    {
        Position model = positionCommand.toPosition();
        Position positionPersited = positionService.save(model);
        return Response.ok(new PositionCommand(positionPersited)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updatePosition(@PathParam("id")Long id, PositionCommand positionUpdate)
    {
        if(positionService.findById(id) == null)
        {
            NotFoundException notfound= new NotFoundException("ID not Found" + id);
            return Response.serverError().entity(notfound).build();
        }
        else {
            Position positionToChange = positionService.findById(id);
            positionUpdate.setId(positionToChange.getId());
            Position position = positionService.update(positionUpdate.toPosition());
            return Response.ok(new PositionCommand(position)).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response removePosition(@PathParam("id")Long id)
    {
        positionService.delete(Long.valueOf(id));
        return Response.ok().build();
    }
}
