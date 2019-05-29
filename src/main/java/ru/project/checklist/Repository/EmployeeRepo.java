package ru.project.checklist.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.project.checklist.Entity.Employee;
import ru.project.checklist.Repository.Mapper.EmployeeMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepo implements EmployeeDAO {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeMapper employeeMapper1;
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    public EmployeeRepo(DataSource dataSource){
        jdbcTemplate =new JdbcTemplate(dataSource);
    }

    private final static String CREATE = "INSERT INTO Employee(name, birthday,position_id,manager_id,salary) VALUES (?,?,?,?,?)";
    private final static String DELETE = "delete from Employee where id = ?";
    private final static String READ = "select id,name,salary,birthday,position_id,manager_id from employee";
    private final static String UPDATE = "UPDATE Employee SET name = ?, birthday = ?, position = ?, manager = ?, salary = ? WHERE id = ?";
    private final static String FINDBYID="select id,name,salary,birthday,position_id,manager_id where id=?";

    public void create(Employee employee, int managerId, int positionId) {
        jdbcTemplate.update(CREATE, employee.getName(), employee.getBirthday(),positionId,
                managerId,employee.getSalary());
    }
    public void delete(Integer id){
        jdbcTemplate.update(DELETE,id);
    }


    public List<Employee> read(){
        List<Employee> list = jdbcTemplate.query(READ, employeeMapper);
        return list;
    }

    public void update(Employee employee, int managerId, int positionId) {
        jdbcTemplate.update(UPDATE,employee.getName(), employee.getBirthday(), employee.getPosition(),
                employee.getManager(),employee.getSalary(),employee.getId());
    }

    public Employee findById(Integer id) {
    Employee emp= (Employee) jdbcTemplate.queryForObject(FINDBYID,new Object[] { id },employeeMapper1);
    return emp;
    }


}
