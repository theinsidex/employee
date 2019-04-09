package ru.project.checklist.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.project.checklist.Entity.Employee;
import ru.project.checklist.Entity.Position;
import ru.project.checklist.Repository.EmployeeRepo;
import ru.project.checklist.Repository.PositionRepo;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo emplRepo;
    @Autowired
    private PositionRepo positionRepo;

    public void create(Employee employee,int managerId,int positionId){
        Employee employee1Manager=emplRepo.findById(managerId).get();
        Position position=positionRepo.findById(positionId).get();
        employee.setManager(employee1Manager);
        employee.setPosition(position);
        emplRepo.save(employee);
    }
    public Iterable<Employee> read()
    {
       return emplRepo.findAll();

    }
    public void update(Employee employee){
    emplRepo.save(employee);
    }
    public void delete(Integer id) {
        emplRepo.deleteById(id);
    }

    public Optional<Employee> findById(Integer id){
        return emplRepo.findById(id);
    }

}
