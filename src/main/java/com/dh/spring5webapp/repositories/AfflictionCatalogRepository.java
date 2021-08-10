package com.dh.spring5webapp.repositories;

import com.dh.spring5webapp.model.AfflictionCatalog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AfflictionCatalogRepository extends CrudRepository<AfflictionCatalog, Long> {
    @Query("SELECT a FROM AfflictionCatalog a WHERE a.deleted = :active ")
    public List<AfflictionCatalog> findCat(@Param("active")boolean active);
}