package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.MachineryCalendaryCommand;
import com.dh.spring5webapp.command.MachineryCommand;
import com.dh.spring5webapp.model.Machinery;

import java.io.InputStream;
import java.util.List;

public interface MachineryService extends GenericService<Machinery> {
    void saveImage(Long id, InputStream file);

    Machinery findByIdNotDeleted(Long id);

    Machinery updateMachinery(MachineryCommand machinery);

    List<MachineryCommand> getAllMachine();

    void delete(Long id);

    List<MachineryCommand> MachineryMes(Long mes);

    List<MachineryCommand> MachineryYear(Long year);

    List<MachineryCalendaryCommand> getMounth();

    List<MachineryCommand> verificarDelete();
}
