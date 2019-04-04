package ru.project.checklist.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.project.checklist.Entity.Employee;

@Controller
public class EmployeeController {
@GetMapping("/")
    public String main()
    {
    return "index";
    }
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("employee", new Employee());
        return "form";
    }
}
