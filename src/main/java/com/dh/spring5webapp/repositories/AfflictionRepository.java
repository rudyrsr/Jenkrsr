package com.dh.spring5webapp.repositories;

import com.dh.spring5webapp.model.Affliction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AfflictionRepository extends CrudRepository<Affliction, Long> {

    @Query("SELECT a FROM Affliction a WHERE a.deleted = :active ")
    public List<Affliction> findAff(@Param("active")boolean active);

}