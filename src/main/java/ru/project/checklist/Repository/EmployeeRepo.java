package ru.project.checklist.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.project.checklist.Entity.Employee;

import java.util.List;
@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

}
