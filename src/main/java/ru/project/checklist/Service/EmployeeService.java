package ru.project.checklist.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.project.checklist.Entity.Employee;
import ru.project.checklist.Repository.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo emplRepo;

    public void create(Employee employee){
        emplRepo.save(employee);
    }
    public Iterable<Employee> read()
    {
       return emplRepo.findAll();

    }
    public void update(Employee employee){
    emplRepo.save(employee);
    }
    public void delete(Long id) {
        emplRepo.deleteById(id);
    }

}
