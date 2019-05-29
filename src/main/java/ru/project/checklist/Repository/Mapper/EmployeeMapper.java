package ru.project.checklist.Repository.Mapper;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.project.checklist.Entity.Employee;
import ru.project.checklist.Entity.Position;
import ru.project.checklist.Repository.EmployeeService;
import ru.project.checklist.Repository.PositionDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

@Component
public class EmployeeMapper implements RowMapper<Employee> {

    private ru.project.checklist.Service.PositionService posServ;
    private EmployeeService empServ;
    @Autowired
    public EmployeeMapper(ru.project.checklist.Service.PositionService posServ, EmployeeService empServ){
        this.posServ=posServ;
        this.empServ=empServ;
    }
    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee emp = new Employee();
        emp.setId(resultSet.getInt("id"));
        emp.setName(resultSet.getString("name"));

        Optional<Position> pos = posServ.findById(resultSet.getInt("position_id"));
        emp.setPosition(pos.get());
        emp.setBirthday(LocalDate.from(resultSet.getTimestamp("birthday").toLocalDateTime()));
        Employee man=empServ.findById(resultSet.getInt("manager_id"));
        emp.setManager(man);
        emp.setSalary(resultSet.getInt("salary"));
         return emp;
      }
}
