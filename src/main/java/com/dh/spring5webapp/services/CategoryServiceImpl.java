/**
 * @author: edson
 */

package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.CategoryCommand;
import com.dh.spring5webapp.model.Category;
import com.dh.spring5webapp.repositories.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl extends GenericServiceImpl<Category> implements CategoryService {
    private static Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
    private CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    protected CrudRepository<Category, Long> getRepository() {
        return repository;
    }

    @Override
    public Category updateCategory(CategoryCommand categoryCommand, Category category) {
        category.setName(categoryCommand.getNameCategory());
        category.setCode(categoryCommand.getCode());
        return category;
    }

    @Override
    public List<CategoryCommand> getCategories() {
        List<CategoryCommand> categoryList = new ArrayList<>();
        repository.findAll().forEach(category -> {
            categoryList.add(new CategoryCommand(category));
        });
        List<CategoryCommand> seleccionCategory = new ArrayList<>();
        int i = 0;
        while (categoryList.size() > i) {
            if (categoryList.get(i).isDeleted() == false) {
                seleccionCategory.add(categoryList.get(i));
            }
            i++;
        }
        return seleccionCategory;
    }

    @Override
    public CategoryCommand findByIdCategory(Long id) {
        CategoryCommand catcom = new CategoryCommand(repository.findById(id).get());
        CategoryCommand res = new CategoryCommand();
        if (catcom.isDeleted() == false) {
            res = catcom;
        }
        return res;
    }

    @Override
    public void desactiveCategory(Long id) {
        Category category = repository.findById(id).get();
        category.setDeleted(true);
        repository.save(category);
    }
}