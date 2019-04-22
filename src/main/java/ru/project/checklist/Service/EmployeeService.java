package ru.project.checklist.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import ru.project.checklist.Entity.Employee;
import ru.project.checklist.Entity.Position;
import ru.project.checklist.Repository.EmployeeRepo;
import ru.project.checklist.Repository.PositionRepo;

import javax.persistence.EntityManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo emplRepo;
    @Autowired
    private PositionRepo positionRepo;
    @Autowired
    private EntityManager entityManager;

    public Employee create(Employee employee, int managerId, int positionId) {
        Employee employee1Manager = emplRepo.findById(managerId).get();
        Position position = positionRepo.findById(positionId).get();
        employee.setManager(employee1Manager);
        employee.setPosition(position);
        emplRepo.save(employee);
        return employee1Manager;
    }

    public Iterable<Employee> read() {
        return emplRepo.findAll();

    }

    public Employee update(Employee employee) {
        emplRepo.save(employee);
        return employee;
    }

    public void delete(Integer id) {
        emplRepo.deleteById(id);
    }

    public Optional<Employee> findById(Integer id) {
        return emplRepo.findById(id);
    }

//    @Query("select e\n" +
//            "from employee emp\n" +
//            "inner join employee empl on emp.manager_id=empl.id\n" +
//            "where empl.id=?#{[0]}")
//     public List<Employee> findUsersByAge(Integer id);
//    }
    public List<Employee> findUserByManager(Integer id){
        List<Employee> employees= (List<Employee>) entityManager.createQuery("select e " +
          "from Employee emp" +
          "inner join Employee empl on emp.manager_id=empl.id\n" +
           "where empl.id=2").getResultList();
    }
}
