/**
 * @author: edson
 */

package com.dh.spring5webapp.controller;

import com.dh.spring5webapp.command.AuditHistoryCommand;
import com.dh.spring5webapp.services.AuditHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/auditory")
@Produces(MediaType.APPLICATION_JSON)
@Controller
@CrossOrigin
public class AuditHistoryController {
    private AuditHistoryService service;

    public AuditHistoryController(AuditHistoryService service) {
        this.service = service;
    }

    @GET
    public Response getEmployees() {
        List<AuditHistoryCommand> auditList = new ArrayList<>();
        service.findAll().forEach(audit -> {
            auditList.add(new AuditHistoryCommand(audit));
        });
        return Response.ok(auditList).build();
    }


}