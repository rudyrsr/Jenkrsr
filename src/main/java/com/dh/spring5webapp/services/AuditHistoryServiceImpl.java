package com.dh.spring5webapp.services;

import com.dh.spring5webapp.model.AuditHistory;
import com.dh.spring5webapp.repositories.AuditHistoryRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AuditHistoryServiceImpl extends GenericServiceImpl<AuditHistory> implements AuditHistoryService {
    private AuditHistoryRepository repository;

    public AuditHistoryServiceImpl(AuditHistoryRepository repository) {
        this.repository = repository;
    }

    @Override
    protected CrudRepository<AuditHistory, Long> getRepository() {
        return repository;
    }

}

