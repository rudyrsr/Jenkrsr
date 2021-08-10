package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.PositionCommand;
import com.dh.spring5webapp.model.Position;

import java.util.List;

public interface PositionService extends GenericService<Position> {
    public Position update(Position position);
    public void delete(Long id);
    public List<PositionCommand> getAllPositions();
}
