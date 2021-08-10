/**
 * @author: Edson A. Terceros T.
 */

package com.dh.spring5webapp.services;

import com.dh.spring5webapp.model.SubCategory;

import java.util.List;

public interface GenericService<T> {
    List<T> findAll();
    T findById(Long id);
    boolean findByIdB(Long id);
    T save(T model);
    void deleteById(Long id);
}