/**
 * @author: Edson A. Terceros T.
 */

package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.SubCategoryCommand;
import com.dh.spring5webapp.model.Category;
import com.dh.spring5webapp.model.SubCategory;

import java.util.List;

public interface SubCategoryService extends GenericService<SubCategory> {
    SubCategory updateSubcategory(SubCategory s, Category c, SubCategoryCommand sc);

    List<SubCategoryCommand> getSubcategories();

    SubCategoryCommand findByIdSubcategory(Long id);

    void desactiveSubcategory(Long id);
}