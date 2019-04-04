package ru.project.checklist.Repository;

import org.springframework.data.repository.CrudRepository;
import ru.project.checklist.Entity.Employee;

import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {
}
