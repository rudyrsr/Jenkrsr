package com.dh.spring5webapp.controller;

import com.dh.spring5webapp.command.MaintenanceCommand;
import com.dh.spring5webapp.model.Maintenance;
import com.dh.spring5webapp.services.MachineryService;
import com.dh.spring5webapp.services.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Controller
@Path("/maintenance")
@Produces("application/json")
@CrossOrigin

public class MaintenanceController {
    @Autowired
    private MaintenanceService maintenanceService;
    @Autowired
    private MachineryService machineryService;

    @GET
    public Response getAllMaintenance() {
        List<MaintenanceCommand> maintenances = maintenanceService.getAllMaintenance();
        return Response.ok(maintenances).build();
    }

    @GET
    @Path("/{id}")
    public Response getMaintenanceById(@PathParam("id") @NotNull Long id) {
        Maintenance maintenance = maintenanceService.findByIdNotDeleted(id);
        return Response.ok(new MaintenanceCommand(maintenance)).build();
    }

    @POST
    public Response saveMaintenance(MaintenanceCommand maintenance) {
        Maintenance model = maintenance.toDomain();
        model.setMachinery(machineryService.findById(maintenance.getMachineryId()));
        model = maintenanceService.save(model);
        return Response.ok(new MaintenanceCommand(model)).build();
    }

    @PUT
    public Response updateMaintence(MaintenanceCommand maintenanceCommand) {
        Maintenance maintenanceV = maintenanceCommand.toDomain();
        if (maintenanceService.findByIdB(maintenanceCommand.getId()) == true) {
            maintenanceV = maintenanceService.updateMaintence(maintenanceCommand);
        }
        return Response.ok(new MaintenanceCommand(maintenanceV)).build();
    }


    @DELETE
    @Path("/{id}")
    public Response deleteMaintenace(@PathParam("id") String id) {
        maintenanceService.deleted(Long.valueOf(id));
        return Response.ok().build();
    }

}
