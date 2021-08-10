package com.dh.spring5webapp.services;

import com.dh.spring5webapp.command.PositionCommand;
import com.dh.spring5webapp.model.Position;
import com.dh.spring5webapp.repositories.PositionRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PositionServiceImpl extends GenericServiceImpl<Position> implements PositionService {
    private PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    protected CrudRepository<Position, Long> getRepository() {
        return positionRepository;
    }

    @Override
    public Position update(Position positionUpdate) {
        Position position = positionRepository.findById(positionUpdate.getId()).get();
        position.setName(positionUpdate.getName());
        position.setPositionCode(positionUpdate.getPositionCode());
        position.setPositionDescription(positionUpdate.getPositionDescription());
        position.setPositionType(positionUpdate.getPositionType());
        position.setCreatedOn(positionUpdate.getUpdatedOn());
        position.setCreatedOn(positionUpdate.getUpdatedOn());
        Position positionPersisted = positionRepository.save(position);
        return positionPersisted;
    }

    @Override
    public void delete(Long id) {
        Position positionToDelete = positionRepository.findById(id).get();
        positionToDelete.setDeleted(true);
        positionRepository.save(positionToDelete);
    }

    @Override
    public List<PositionCommand> getAllPositions() {
        List<PositionCommand> positions = verifyDeleted();
        return positions;
    }

    private List<PositionCommand> verifyDeleted()
    {
        List<PositionCommand> positionList = new ArrayList<>();
        positionRepository.findAll().forEach(pos -> {
            positionList.add(new PositionCommand(pos));
        });
        List<PositionCommand> notDeleted = new ArrayList<>();
        int i = 0;
        boolean valor = false;
        while (positionList.size() > i) {
            valor = positionList.get(i).isDeleted();
            if (valor == false) {
                notDeleted.add(positionList.get(i));
            }
            i++;
        }
        return notDeleted;
    }

}
