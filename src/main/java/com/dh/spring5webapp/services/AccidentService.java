package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.AccidentComand;
import com.dh.spring5webapp.model.Accident;


import com.dh.spring5webapp.model.Employee;


import javax.ws.rs.core.Response;
import java.util.List;

public interface AccidentService extends GenericService<Accident> {

    Accident updateAccident(AccidentComand accident);

    List<AccidentComand> getAllaccidents();

    AccidentComand findByIdA(Long id);

    AccidentComand findCodigoAccident(String codigo);

    AccidentComand findCodeAccidents(String code);

    Accident CreateAccident(AccidentComand accident);

    void deleteAccident(Long id);

    void desactivateAccident(Long id);


}
