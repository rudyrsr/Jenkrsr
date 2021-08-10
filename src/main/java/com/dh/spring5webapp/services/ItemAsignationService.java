package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.ItemAsignationCommand;
import com.dh.spring5webapp.model.Employee;
import com.dh.spring5webapp.model.Item;
import com.dh.spring5webapp.model.ItemAsignation;

public interface ItemAsignationService extends GenericService<ItemAsignation> {
    ItemAsignation updateItemAsig(ItemAsignationCommand iac, Employee e, Item i, ItemAsignation ia);
}
