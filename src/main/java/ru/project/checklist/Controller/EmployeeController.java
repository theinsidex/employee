package ru.project.checklist.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
@GetMapping("/")
    public String main()
    {
    return "index";
    }
}
