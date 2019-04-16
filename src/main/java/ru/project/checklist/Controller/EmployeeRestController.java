package ru.project.checklist.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.project.checklist.Entity.Employee;
import ru.project.checklist.Service.EmployeeService;
import ru.project.checklist.Service.PositionService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("rest")
public class EmployeeRestController {
    @Autowired
    private EmployeeService emplService;
    @Autowired
    private PositionService positionService;

    @RequestMapping(value = "/employees",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Employee> read() {
        List<Employee> employees = (List<Employee>) emplService.read();
        return employees;
    }

    @RequestMapping(value = "/employee",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee emp,
                                @RequestParam int managerId,
                                @RequestParam int positionId) {
        return emplService.create(emp, managerId, positionId);
    }

    @RequestMapping(value = "/employee",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Employee update(@RequestBody Employee emp) {

        return emplService.update(emp);
    }

    @RequestMapping(value = "/employees/{empNo}",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void deleteEmployee(@PathVariable("empNo") Integer empNo) {
        emplService.delete(empNo);
    }

    @RequestMapping(value = "/employee/{id}/subordinates",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Employee> getEmployeeByManager(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        List<Employee> employees = (List<Employee>) emplService.read();
        List<Employee> byManager = employees.stream()
                .filter(x -> x.getManager() != null)
                .filter(x -> x.getManager().getId().equals(id))
                .collect(Collectors.toList());
        if (byManager.isEmpty()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        return byManager;
    }
}
