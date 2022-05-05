package com.example.task15.controllers;

import com.example.task15.services.EmailSenderService;
import com.example.task15.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/showing")
public class ShowingController {

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private Service service;

    @GetMapping("/gameAuthor")
    public String showingGameAuthor(@RequestParam("name") String name, Model model) {
        String info = service.showingGameAuthor(name);
        if(info == null) {
            model.addAttribute("message", "Game author with name " + name + " is not exits");
            emailSenderService.sendEmail("grisha101202@yandex.ru", "task21", "Game author with name " + name + " is not exits");
        }
        else {
            model.addAttribute("message", "Info about game author with name " + name + ": " + info);
            emailSenderService.sendEmail("grisha101202@yandex.ru", "task21", "Info about game author with name " + name + ": " + info);
        }

        return "home";
    }

    @GetMapping("/game")
    public String showingGame(@RequestParam("name") String name, Model model) {
        String info = service.showingGame(name);
        if(info == null) {
            model.addAttribute("message", "Game with name " + name + " is not exxits");
            emailSenderService.sendEmail("grisha101202@yandex.ru", "task21", "Game with name " + name + " is not exxits");
        }
        else {
            model.addAttribute("message", "Info about game with name " + name + ": " + info);
            emailSenderService.sendEmail("grisha101202@yandex.ru", "task21", "Info about game with name " + name + ": " + info);
        }
        return "home";
    }
}
