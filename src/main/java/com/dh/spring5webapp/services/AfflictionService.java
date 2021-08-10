package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.AfflictionCommand;
import com.dh.spring5webapp.model.Affliction;

import java.util.List;

public interface AfflictionService extends GenericService<Affliction> {
    List<AfflictionCommand> getAllAfflictions();

    Affliction findByIdNotDeleted(Long id);

    /*Affliction afflictionUpdate(Affliction afflictionSet, Affliction afflictionUp);*/
    Affliction update(Affliction afflictionUpdate);

    void delete(Long id);
}