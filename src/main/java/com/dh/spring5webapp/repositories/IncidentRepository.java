package com.dh.spring5webapp.repositories;

import com.dh.spring5webapp.model.Incident;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IncidentRepository extends CrudRepository<Incident, Long> {

    @Query("SELECT a FROM Incident a WHERE a.deleted = :active ")
    public List<Incident> findIncid(@Param("active")boolean active);
}