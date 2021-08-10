package com.dh.spring5webapp.controller;

import com.dh.spring5webapp.command.ItemAsignationCommand;
import com.dh.spring5webapp.model.Employee;
import com.dh.spring5webapp.model.Item;
import com.dh.spring5webapp.model.ItemAsignation;
import com.dh.spring5webapp.services.EmployeeService;
import com.dh.spring5webapp.services.ItemAsignationService;
import com.dh.spring5webapp.services.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Controller
@Path("/itemAsignation")
@Produces("application/json")
@CrossOrigin
public class ItemAsignationController {
    private ItemAsignationService itemAsignationService;
    private EmployeeService employeeService;
    private ItemService itemService;

    public ItemAsignationController(ItemAsignationService itemAsignationService, EmployeeService employeeService, ItemService itemService) {
        this.itemAsignationService = itemAsignationService;
        this.employeeService = employeeService;
        this.itemService = itemService;
    }

    @GET
    public Response getItemAsignation() {
        List<ItemAsignationCommand> itemAssignations = new ArrayList<>();
        itemAsignationService.findAll().forEach(itemAsignation -> {
            ItemAsignationCommand itemAsignationCommand = new ItemAsignationCommand(itemAsignation);
            itemAssignations.add(itemAsignationCommand);
        });
        return Response.ok(itemAssignations).build();
    }

    @GET
    @Path("/{id}")
    public Response getItemAsignationById(@PathParam("id") @NotNull Long id) {
        ItemAsignation itemAsignation = itemAsignationService.findById(id);
        return Response.ok(new ItemAsignationCommand(itemAsignation)).build();
    }

    @POST
    public Response saveItemAsignation(ItemAsignationCommand itemAsignationCommand) {
        ItemAsignation model = itemAsignationCommand.toItemAsignation();
        model.setEmployee(employeeService.findById(itemAsignationCommand.getEmployeeId()));
        model.setItem(itemService.findById(itemAsignationCommand.getItemId()));
        ItemAsignation persisted = itemAsignationService.save(model);
        return Response.ok(new ItemAsignationCommand(persisted)).build();
    }

    @PUT
    public Response updateItemAsignation(ItemAsignationCommand itemAsignationCommand) {
        ItemAsignation itemAsignation = itemAsignationService.findById(itemAsignationCommand.getId());
        Employee employee = employeeService.findById(itemAsignationCommand.getEmployeeId());
        Item item = itemService.findById(itemAsignationCommand.getItemId());
        ItemAsignation actual = itemAsignationService.updateItemAsig(itemAsignationCommand, employee, item, itemAsignation);
        ItemAsignation persisted = itemAsignationService.save(actual);
        return Response.ok(new ItemAsignationCommand(persisted)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteItemAsignation(@PathParam("id") String id) {
        itemAsignationService.deleteById(Long.valueOf(id));
        return Response.ok().build();
    }

    @OPTIONS
    public Response prefligth() {
        return Response.ok().build();
    }
}
