package com.dh.spring5webapp.repositories;

import com.dh.spring5webapp.model.Accident;
import org.springframework.data.repository.CrudRepository;

public interface AccidentRepository extends CrudRepository<Accident, Long> {
}
