/**
 * @author: Edson A. Terceros T.
 */

package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.AccidentComand;
import com.dh.spring5webapp.exceptions.NotFoundException;
import com.dh.spring5webapp.model.MachineryAssignation;
import com.dh.spring5webapp.model.SubCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericServiceImpl<T> implements GenericService<T> {

    @Override
    public List<T> findAll() {
        List<T> results = new ArrayList<>();
        getRepository().findAll().forEach(results::add);
        return results;
    }

    @Override
    public T findById(Long id) {

        Optional<T> optional = getRepository().findById(id);
        if (!optional.isPresent()) {
            String typeName = (((ParameterizedType) getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName();
            typeName = typeName.substring(typeName.lastIndexOf(".") + 1);
            throw new NotFoundException(typeName + " id:" + id + " Not Found");
        }
        return optional.get();
    }
    public boolean findByIdB(Long id) {
        Optional<T> optional = getRepository().findById(id);
        boolean v=true;
        if (!optional.isPresent()) {
            v=false;
        }
        return v;
    }
    @Override
    public T save(T model) {

        return getRepository().save(model);

    }
    @Override
    public void deleteById(Long id) {
        getRepository().deleteById(id);
    }

    protected abstract CrudRepository<T, Long> getRepository();

}