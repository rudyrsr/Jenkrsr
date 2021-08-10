package com.dh.spring5webapp.controller;

import com.dh.spring5webapp.command.SubCategoryCommand;
import com.dh.spring5webapp.model.Category;
import com.dh.spring5webapp.model.SubCategory;
import com.dh.spring5webapp.services.CategoryService;
import com.dh.spring5webapp.services.SubCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Controller
@Path("/subcategories")
@Produces("application/json")
@CrossOrigin
public class SubCategoryController {
    private SubCategoryService service;
    private CategoryService categoryService;

    public SubCategoryController(SubCategoryService service, CategoryService categoryService) {
        this.service = service;
        this.categoryService = categoryService;
    }

    @GET
    public Response getSubcategories() {
        List<SubCategoryCommand> subcategories = service.getSubcategories();
        return Response.ok(subcategories).build();
    }

    @GET
    @Path("/{id}")
    public Response getSubcategoryById(@PathParam("id") @NotNull Long id) {
        SubCategoryCommand subCategory = service.findByIdSubcategory(id);
        return Response.ok(subCategory).build();
    }

    @POST
    public Response saveSubcategory(SubCategoryCommand subCategoryCommand) {
        SubCategory model = subCategoryCommand.toSubCategory();
        model.setCategory(categoryService.findById(subCategoryCommand.getCategoryId()));
        SubCategory persisted = service.save(model);
        return Response.ok(new SubCategoryCommand(persisted)).build();
    }

    @PUT
    public Response updateSubcategory(SubCategoryCommand subCategoryCommand) {
        SubCategory subCategory = service.findById(subCategoryCommand.getIdSub());
        Category category = categoryService.findById(subCategoryCommand.getCategoryId());
        SubCategory sub = service.updateSubcategory(subCategory, category, subCategoryCommand);
        SubCategory persisted = service.save(sub);
        return Response.ok(new SubCategoryCommand(persisted)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteSubcategory(@PathParam("id") String id) {
        service.desactiveSubcategory(Long.valueOf(id));
        return Response.ok().build();
    }

    @OPTIONS
    public Response prefligth() {
        return Response.ok().build();
    }
}
