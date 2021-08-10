package com.dh.spring5webapp.repositories;

import com.dh.spring5webapp.model.AuditHistory;
import org.springframework.data.repository.CrudRepository;

public interface AuditHistoryRepository extends CrudRepository<AuditHistory, Long> {
}