package com.dh.spring5webapp.controller;

import com.dh.spring5webapp.command.CategoryCommand;
import com.dh.spring5webapp.model.Category;
import com.dh.spring5webapp.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Controller
@Path("/categories")
@Produces("application/json")
@CrossOrigin
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //cambie el metodo get @QueryParam("code") String code
    @GET
    public Response getCategories() {
        List<CategoryCommand> categories = categoryService.getCategories();
        return Response.ok(categories).build();
    }

    //cambie el metodo get
    @GET
    @Path("/{id}")
    public Response getCategoriesById(@PathParam("id") @NotNull Long id) {
        CategoryCommand category = categoryService.findByIdCategory(id);
        return Response.ok(category).build();
    }

    //aniadi el metodo post
    @POST
    public Response saveCategory(CategoryCommand categoryCommand) {
        Category modelCateg = categoryCommand.toCategory();
        Category categoryPersisted = categoryService.save(modelCateg);
        return Response.ok(new CategoryCommand(categoryPersisted)).build();
    }

    //aniadi el metodo put
    @PUT
    public Response updateCategory(CategoryCommand categoryCommand) {
        Category category = categoryService.findById(categoryCommand.getIdCateg());
        Category category1 = categoryService.updateCategory(categoryCommand, category);
        Category categoryPersisted = categoryService.save(category1);
        return Response.ok(categoryPersisted).build();
    }

    //aniadi el metodo delete
    @DELETE
    @Path("/{id}")
    public Response deleteCategory(@PathParam("id") String id) {
        categoryService.desactiveCategory(Long.valueOf(id));
        return Response.ok().build();
    }

    @OPTIONS
    public Response prefligth() {
        return Response.ok().build();
    }
}
