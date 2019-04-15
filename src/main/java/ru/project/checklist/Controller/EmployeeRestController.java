package ru.project.checklist.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.project.checklist.Entity.Employee;
import ru.project.checklist.Service.EmployeeService;
import ru.project.checklist.Service.PositionService;

import java.util.List;

@RestController
@RequestMapping("rest")
public class EmployeeRestController {
    @Autowired
    private EmployeeService emplService;
    @Autowired
    private PositionService positionService;
    @RequestMapping(value = "/employees",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Employee> read(){
        List<Employee> employees= (List<Employee>) emplService.read();
        return employees;
    }

    @RequestMapping(value = "/employee",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee emp,
                                @RequestParam int managerId,
                                @RequestParam int positionId){
    return emplService.create(emp,managerId,positionId);
    }

    @RequestMapping(value = "/employee",
            method = RequestMethod.PUT,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public Employee update(@RequestBody Employee emp) {

        return emplService.update(emp);
    }

    @RequestMapping(value = "/employees/{empNo}",
            method = RequestMethod.DELETE,
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void deleteEmployee(@PathVariable("empNo") Integer empNo) {
        emplService.delete(empNo);
    }

}
