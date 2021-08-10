/**
 * @author: Edson A. Terceros T.
 */

package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.CategoryCommand;
import com.dh.spring5webapp.model.Category;

import java.util.List;

public interface CategoryService extends GenericService<Category> {
    Category updateCategory(CategoryCommand cm, Category c);

    List<CategoryCommand> getCategories();

    CategoryCommand findByIdCategory(Long id);

    void desactiveCategory(Long id);
}
