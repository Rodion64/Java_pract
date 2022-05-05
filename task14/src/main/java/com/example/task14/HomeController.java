package com.example.task14;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String nameOfStudent(Model m) {
        m.addAttribute("message", "Голубев Григорий Александрович ИКБО-16-20");
        return "home";
    }
}
