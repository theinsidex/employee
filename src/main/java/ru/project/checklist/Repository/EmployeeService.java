package ru.project.checklist.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.project.checklist.Entity.Employee;
import ru.project.checklist.Repository.EmployeeRepo;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo emplRepo;

    public void create(Employee employee, int managerId, int positionId) {
            emplRepo.create(employee,managerId,positionId);
    }


    public List<Employee> read() {
      return emplRepo.read();
    }

    public void update(Employee employee,int managerId,int positionId) {
        emplRepo.update(employee,managerId,positionId);
    }

    public void delete(Integer id) {
        emplRepo.delete(id);
    }


    public Employee findById(Integer id) {
        return emplRepo.findById(id);
    }
}
