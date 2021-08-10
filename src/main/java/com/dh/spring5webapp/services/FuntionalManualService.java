package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.FuntionalManualCommand;
import com.dh.spring5webapp.model.FuntionalManual;

import java.util.List;

public interface FuntionalManualService extends GenericService<FuntionalManual> {
     List<FuntionalManualCommand> getAllFunctionalManual();

     FuntionalManual findByIdNotDeleted(Long id);

     FuntionalManualCommand update(FuntionalManualCommand funtionalManual);

     void delete(Long id);
}
