package ru.project.checklist.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.project.checklist.Entity.Employee;
import ru.project.checklist.Entity.Position;
import ru.project.checklist.Repository.EmployeeService;
import ru.project.checklist.Util.MethodUtils;

import java.util.List;


@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService emplService;
    @Autowired
    private ru.project.checklist.Service.PositionService positionService;

    @GetMapping("/")
    public String main(Model model) {
        return "index";
    }

    @GetMapping("/employee")
    public String read(Model model) {
        List<Employee> employees= emplService.read();
        model.addAttribute("employees", employees);
        return "listempl";
    }

    @GetMapping("/employee/create")
    public String add(Model model) {
        model.addAttribute("employee", new Employee());
        List<Position> positions = (List<Position>) positionService.read();
        model.addAttribute("positions", positions);
        List<Employee> managers = (List<Employee>) emplService.read();
        model.addAttribute("managers", managers);
        return "form";
    }

    @PostMapping("/employee/save")
    public String save(Employee employee,
                       @RequestParam int managerId,
                       @RequestParam int positionId,
                       Model model) {

        emplService.create(employee, managerId, positionId);

        return "redirect:/employee";
    }

    @GetMapping("/employee/{id}/delete")
    public String delete(@PathVariable Integer id) {
        emplService.delete(id);
        return "redirect:/employee";
    }

    @GetMapping("/employee/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("employee", emplService.findById(id));
        List<Position> positions = (List<Position>) positionService.read();
        model.addAttribute("positions", positions);
        List<Employee> managers = (List<Employee>) emplService.read();
        model.addAttribute("managers", managers);
        return "formedit";
    }

}
