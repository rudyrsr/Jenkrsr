package com.dh.spring5webapp.repositories;

import com.dh.spring5webapp.model.IncidentCatalog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IncidentCatalogRepository extends CrudRepository<IncidentCatalog, Long> {
    @Query("SELECT a FROM IncidentCatalog a WHERE a.deleted = :active ")
    public List<IncidentCatalog> findCat(@Param("active")boolean active);
}