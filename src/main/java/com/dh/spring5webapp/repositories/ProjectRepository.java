package com.dh.spring5webapp.repositories;

import com.dh.spring5webapp.model.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Query("SELECT a FROM Project a WHERE a.deleted = :active ")
    public List<Project> findProj(@Param("active")boolean active);
}