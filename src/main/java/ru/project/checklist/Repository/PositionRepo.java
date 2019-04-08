package ru.project.checklist.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.project.checklist.Entity.Position;

import java.util.List;
@Repository
public interface PositionRepo extends CrudRepository<Position,Long> {
    List<Position> findByName(String name);
}
