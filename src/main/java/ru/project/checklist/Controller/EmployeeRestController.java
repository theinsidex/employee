package ru.project.checklist.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.project.checklist.Entity.Employee;
import ru.project.checklist.Repository.EmployeeService;


import java.util.List;

@RestController
@RequestMapping("rest")
public class EmployeeRestController {
    @Autowired
    private EmployeeService emplService;
    @Autowired
    private ru.project.checklist.Service.PositionService positionService;

    @RequestMapping(value = "/employees",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE}
            )
    @ResponseBody
    public List<Employee> read() {
        List<Employee> employees = emplService.read();
        return employees;
    }

    @RequestMapping(value = "/employee",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee emp,
                                @RequestParam int managerId,
                                @RequestParam int positionId) {
        Employee employee=new Employee();
       emplService.create(emp, managerId, positionId);
        return employee;
    }

    @RequestMapping(value = "/employee",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void update(@RequestBody Employee emp,
                           @RequestParam int managerId,
                           @RequestParam int positionId) {
        emplService.update(emp,managerId,positionId);
    }

    @RequestMapping(value = "/employees/{empNo}",
            method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void deleteEmployee(@PathVariable("empNo") Integer empNo) {
        emplService.delete(empNo);
    }

//    @RequestMapping(value = "/employee/{id}/subordinates",
//            method = RequestMethod.GET,
//            produces = {MediaType.APPLICATION_JSON_VALUE})
//    @ResponseBody
//    public List<Employee> getByManager(@PathVariable Integer id){
//        Optional<Employee> manager = emplService.findById(id);
//        return (List<Employee>) manager.get().getSubordinates();
//
//        //return (List<Employee>) emplService.getByManager(id).get();
//    }

}
