package ru.project.checklist.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.project.checklist.Entity.Employee;
import ru.project.checklist.Entity.Position;
import ru.project.checklist.Repository.EmployeeRepo;
import ru.project.checklist.Service.EmployeeService;
import ru.project.checklist.Service.PositionService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService emplService;
    @Autowired
    private PositionService positionService;

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
        List<Position> positions= (List<Position>) positionService.read();
        model.addAttribute("positions",positions);
        List<Employee> managers= (List<Employee>) emplService.read();
        model.addAttribute("managers",managers);
        return "form";
    }
    @PostMapping("/employee/save")
    public String save(Employee employee,
                       @RequestParam int managerId,
                       @RequestParam int positionId,
                       Model model) {

        emplService.create(employee,managerId,positionId);

        return "redirect:/employee";
    }
    @GetMapping("/employee/{id}/delete")
    public String delete(@PathVariable Integer id) {
        emplService.delete(id);
        return "redirect:/listempl";
    }
    @GetMapping("/employee/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("employee", emplService.findById(id));
        return "form";
    }

}
