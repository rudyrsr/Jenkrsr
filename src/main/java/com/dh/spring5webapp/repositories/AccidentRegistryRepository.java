package com.dh.spring5webapp.repositories;

import com.dh.spring5webapp.model.Accident;
import com.dh.spring5webapp.model.AccidentRegistry;
import org.springframework.data.repository.CrudRepository;

public interface AccidentRegistryRepository extends CrudRepository<AccidentRegistry, Long>  {
}
