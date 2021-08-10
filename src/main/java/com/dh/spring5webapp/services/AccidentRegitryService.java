package com.dh.spring5webapp.services;


import com.dh.spring5webapp.command.AccidentRegistryComand;
import com.dh.spring5webapp.command.CalendaryCommand;
import com.dh.spring5webapp.model.AccidentRegistry;

import java.util.List;

public interface AccidentRegitryService extends GenericService<AccidentRegistry> {

    List<AccidentRegistryComand> getAllaccidents();

    List<AccidentRegistryComand> AccidentYear(Long anio);

    AccidentRegistry createRegistryA(AccidentRegistryComand modelN);

    AccidentRegistry updateRegistyA(AccidentRegistryComand modelN);

    void deleteAccident(Long id);

    void desactivateAccidentR(Long id);

    boolean Verificar(Long employeid, Long accidentid);

    AccidentRegistryComand findByIdRA(Long id);

    List<AccidentRegistryComand> AccidentMes(Long mes,Long anio);

    List<CalendaryCommand> getMounthss();
}
