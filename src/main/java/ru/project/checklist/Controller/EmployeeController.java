package ru.project.checklist.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.project.checklist.Entity.Employee;
import ru.project.checklist.Entity.Position;
import ru.project.checklist.Repository.EmployeeRepo;
import ru.project.checklist.Service.EmployeeService;
import ru.project.checklist.Service.PositionService;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService emplService;
    @GetMapping("/")
    public String main(Model model)
    {
        return "index";
    }
    @GetMapping("/employee")
    public String read(Model model)
    {
        List<Employee> employees= (List<Employee>) emplService.read();
        model.addAttribute("employees", employees);
        return "listempl";
    }
    @GetMapping("/employee/create")
    public String add(Model model) {
        model.addAttribute("employee", new Employee());
        return "form";
    }
    @GetMapping("/employee/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("employee", emplService.findById(id));
        return "form";
    }
}
