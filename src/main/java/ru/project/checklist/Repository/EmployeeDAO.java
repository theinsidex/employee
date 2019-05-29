package ru.project.checklist.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.project.checklist.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {
    void create(Employee employee, int managerId, int positionId);
    void delete(Integer id);
    List<Employee> read();
    void update(Employee employee,int managerId, int positionId);
    Employee findById(Integer id);

     
}
