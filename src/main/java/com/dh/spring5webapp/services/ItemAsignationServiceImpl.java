package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.ItemAsignationCommand;
import com.dh.spring5webapp.model.Employee;
import com.dh.spring5webapp.model.Item;
import com.dh.spring5webapp.model.ItemAsignation;
import com.dh.spring5webapp.repositories.ItemAsignationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemAsignationServiceImpl extends GenericServiceImpl<ItemAsignation> implements ItemAsignationService {
    private static Logger logger = LoggerFactory.getLogger(ItemAsignationServiceImpl.class);
    private ItemAsignationRepository repository;

    public ItemAsignationServiceImpl(ItemAsignationRepository repository) {
        this.repository = repository;
    }

    @Override
    protected CrudRepository<ItemAsignation, Long> getRepository() {
        return repository;
    }

    @Override
    public ItemAsignation updateItemAsig(ItemAsignationCommand iac, Employee e, Item i, ItemAsignation ia) {
        ia.setDescription(iac.getDescription());
        ia.setEmployee(e);
        ia.setItem(i);
        ia.setInitDateIA(iac.getInitDateIA());
        ia.setEndDateIA(iac.getEndDateIA());
        ia.setStateActualItem(iac.getStateActual());
        ia.setEmpId(e.getId());
        ia.setItId(i.getId());
        return ia;
    }
}
