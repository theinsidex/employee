package ru.project.checklist.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.project.checklist.Entity.Position;


import java.util.List;

@Controller
public class PositionController {
    @Autowired
    private ru.project.checklist.Service.PositionService positionService;
    @GetMapping("/position")
    public String depart(Model model)
    {
        List<Position> positions= (List<Position>) positionService.read();
        model.addAttribute("positions",positions);
        return "depart";
    }

}
