package com.dh.spring5webapp.controller;

import com.dh.spring5webapp.command.ContractCommand;
import com.dh.spring5webapp.command.MachineryAssignationCommand;
import com.dh.spring5webapp.exceptions.NotFoundException;
import com.dh.spring5webapp.model.Contract;
import com.dh.spring5webapp.services.ContractService;
import com.dh.spring5webapp.services.EmployeeService;
import com.dh.spring5webapp.services.PositionService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Controller
@Path("/contracts")
@Produces("application/json")
public class ContractController {
    private ContractService contractService;
    private EmployeeService employeeService;
    private PositionService positionService;

    public ContractController(ContractService contractService,
                              EmployeeService employeeService, PositionService positionService) {
        this.contractService = contractService;
        this.employeeService = employeeService;
        this.positionService = positionService;
    }

    @GET
    public Response getContracts()
    {
        List<ContractCommand> contractCommands = new ArrayList<>();
        contractCommands = contractService.getAllContracts();

        return Response.ok(contractCommands).build();
    }
    @GET
    @Path("/{id}")
    public Response getContractById(@PathParam("id") Long id)
    {
        if (contractService.findById(id) == null)
        {
            NotFoundException notFoundException = new NotFoundException("ID not found "+id);
            return Response.serverError().entity(notFoundException).build();
        }
        else{
        Contract contract = contractService.findById(id);
        return Response.ok(new ContractCommand(contract)).build();
        }
    }

    @POST
    public Response saveContract(ContractCommand contractCommand)
    {
        Contract model = contractCommand.toContract();
        model.setEmployee(employeeService.findById(contractCommand.getEmployeeId()));
        model.setPosition(positionService.findById(contractCommand.getPositionId()));
        Contract contractPersisted = contractService.save(model);
        return Response.ok(new ContractCommand(contractPersisted)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateContract(@PathParam("id") Long id, ContractCommand contractCommand)
    {
        if (contractService.findById(id) == null)
        {
            NotFoundException notFoundException = new NotFoundException("ID not found "+id);
            return Response.serverError().entity(notFoundException).build();
        }
        else {
            Contract contractToChange = contractService.findById(id);
            contractCommand.setId(contractToChange.getId());
            Contract contractPersisted = contractService.update(contractCommand.toContract());
            return Response.ok(new ContractCommand(contractPersisted)).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteContract(@PathParam("id") Long id)
    {
        contractService.deleted(id);
        return Response.ok().build();
    }
}
