package com.dh.spring5webapp.repositories;

import com.dh.spring5webapp.model.AsignationProject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AsignationProjectRepository extends CrudRepository<AsignationProject, Long> {
    /*@Query("select u from AsignationProject u where u.employee = :em and u.project = :pr")
    AsignationProject findAsigmentProjectByidEmployeeByIdProject(@Param("em") Long em, @Param("pr") Long pr);
*/
    @Query("SELECT a FROM AsignationProject a WHERE a.deleted = :active ")
    public List<AsignationProject> findAsig(@Param("active")boolean active);
}