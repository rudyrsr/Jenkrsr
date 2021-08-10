/**
 * @author: Edson A. Terceros T.
 */

package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.SubCategoryCommand;
import com.dh.spring5webapp.model.Category;
import com.dh.spring5webapp.model.SubCategory;
import com.dh.spring5webapp.repositories.SubCategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubCategoryServiceImpl extends GenericServiceImpl<SubCategory> implements SubCategoryService {
    private static Logger logger = LoggerFactory.getLogger(SubCategoryServiceImpl.class);
    private SubCategoryRepository repository;

    public SubCategoryServiceImpl(SubCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    protected CrudRepository<SubCategory, Long> getRepository() {
        return repository;
    }

    @Override
    public SubCategory updateSubcategory(SubCategory subCategory, Category category, SubCategoryCommand subCategoryCommand) {
        subCategory.setCode(subCategoryCommand.getCodeSub());
        subCategory.setName(subCategoryCommand.getNameSub());
        subCategory.setCategory(category);
        return subCategory;
    }

    @Override
    public List<SubCategoryCommand> getSubcategories() {
        List<SubCategoryCommand> subcategoryList = new ArrayList<>();
        repository.findAll().forEach(subCategory -> {
            subcategoryList.add(new SubCategoryCommand(subCategory));
        });
        List<SubCategoryCommand> seleccionSubcategory = new ArrayList<>();
        int i = 0;
        while (subcategoryList.size() > i) {
            if (subcategoryList.get(i).isDeleted() == false) {
                seleccionSubcategory.add(subcategoryList.get(i));
            }
            i++;
        }
        return seleccionSubcategory;
    }

    @Override
    public SubCategoryCommand findByIdSubcategory(Long id) {
        SubCategoryCommand subcom = new SubCategoryCommand(repository.findById(id).get());
        SubCategoryCommand res = new SubCategoryCommand();
        if (subcom.isDeleted() == false) {
            res = subcom;
        }
        return res;
    }

    @Override
    public void desactiveSubcategory(Long id) {
        SubCategory subCategory = repository.findById(id).get();
        subCategory.setDeleted(true);
        repository.save(subCategory);
    }
}