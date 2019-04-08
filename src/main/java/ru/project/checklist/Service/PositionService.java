package ru.project.checklist.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.project.checklist.Entity.Position;
import ru.project.checklist.Repository.PositionRepo;

@Service
public class PositionService {
    @Autowired
    private PositionRepo posRepo;

    public void create(Position position){
        posRepo.save(position);
    }
    public Iterable<Position> read()
    {
        return posRepo.findAll();

    }
    public void update(Position position){
        posRepo.save(position);
    }
    public void delete(Long id) {
        posRepo.deleteById(id);
    }
}
