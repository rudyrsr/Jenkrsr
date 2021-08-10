/**
 * @author: Edson A. Terceros T.
 */

package com.dh.spring5webapp.controller;

import com.dh.spring5webapp.command.ItemCommand;
import com.dh.spring5webapp.model.Item;
import com.dh.spring5webapp.model.SubCategory;
import com.dh.spring5webapp.services.ItemService;
import com.dh.spring5webapp.services.SubCategoryService;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.List;

@Controller
@Path("/items")
@Produces("application/json")
@CrossOrigin
public class ItemController {
    private ItemService service;
    private SubCategoryService subCategoryService;

    public ItemController(ItemService service, SubCategoryService subCategoryService) {
        this.service = service;
        this.subCategoryService = subCategoryService;
    }

    @GET
    public Response getItems() {
        List<ItemCommand> items = service.getItems();
        return Response.ok(items).build();
    }

    @GET
    @Path("/{id}")
    public Response getItemsById(@PathParam("id") @NotNull Long id) {
        ItemCommand item = service.findByIdItem(id);
        return Response.ok(item).build();
    }

    @POST
    public Response saveItem(ItemCommand item) {
        Item model = item.toDomain();
        model.setSubCategory(subCategoryService.findById(item.getSubCategoryId()));
        Item itemPersisted = service.save(model);
        return Response.ok(new ItemCommand(itemPersisted)).build();
    }

    @PUT
    public Response updateItem(ItemCommand itemCommand) {
        Item item = service.findById(itemCommand.getId());
        SubCategory subCategory = subCategoryService.findById(itemCommand.getSubCategoryId());
        Item actual = service.updateItem(itemCommand, item, subCategory);
        Item itemPersisted = service.save(actual);
        return Response.ok(new ItemCommand(itemPersisted)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteItem(@PathParam("id") String id) {
        service.desactiveItem(Long.valueOf(id));
        return Response.ok().build();
    }

    @OPTIONS
    public Response prefligth() {
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}/image")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadFile(@PathParam("id") String id,
                               @FormDataParam("file") InputStream file,
                               @FormDataParam("file") FormDataContentDisposition fileDisposition) {
        System.out.println("entrando al metodo");
        service.saveImage(Long.valueOf(id), file);
        return Response.ok("Data uploaded successfully !!").build();
    }

}