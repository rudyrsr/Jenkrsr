package com.dh.spring5webapp.controller;


import com.dh.spring5webapp.command.FuntionalManualCommand;
import com.dh.spring5webapp.model.FuntionalManual;
import com.dh.spring5webapp.model.Position;
import com.dh.spring5webapp.services.FuntionalManualService;
import com.dh.spring5webapp.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Controller
@Path("/functionalmanual")
@Produces("application/json")
public class FuntionalManualController {
    @Autowired
    private FuntionalManualService funtionalManualService;
    @Autowired
    private PositionService positionService;

    @GET
    public Response getAllFunctionalManuals() {
        List<FuntionalManualCommand> functionalManuals = funtionalManualService.getAllFunctionalManual();
        return Response.ok(functionalManuals).build();
    }

    @GET
    @Path("/{id}")
    public Response getAfflictionById(@PathParam("id") @NotNull Long id) {
        FuntionalManual functionalManual = funtionalManualService.findByIdNotDeleted(id);
        return Response.ok(new FuntionalManualCommand(functionalManual)).build();
    }

    @POST
    public Response saveAffliction(FuntionalManualCommand funtionalManualCommand) {
        FuntionalManual toCreate = funtionalManualCommand.toDomain();
        toCreate.setPosition(positionService.findById(funtionalManualCommand.getPositionId()));
        FuntionalManual afflictionPersisted = funtionalManualService.save(toCreate);
        return Response.ok(new FuntionalManualCommand(afflictionPersisted)).build();
    }

    @PUT
    public Response updateAffliction(FuntionalManualCommand funtionalManualCommand) {
        FuntionalManualCommand toUpdate = funtionalManualService.update(funtionalManualCommand);
        return Response.ok(toUpdate).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAffliction(@PathParam("id") String id) {
        funtionalManualService.delete(Long.valueOf(id));
        return Response.ok().build();
    }

    @OPTIONS
    public Response prefligth() {
        return Response.ok().build();
    }

}
