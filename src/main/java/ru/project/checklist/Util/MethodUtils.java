package ru.project.checklist.Util;

import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

public class MethodUtils {
    public static void pageModel(Model model, Page<?> pages) {
        int current = pages.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 5, pages.getTotalPages());

        model.addAttribute("end", end);
        model.addAttribute("begin", begin);
        model.addAttribute("current", current);
        model.addAttribute("totalPages", pages.getTotalPages());
        model.addAttribute("totalElements", pages.getTotalElements());
    }
}
