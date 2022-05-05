package com.example.task15.controllers;

import com.example.task15.services.EmailSenderService;
import com.example.task15.services.Service;
import com.example.task15.repos.GameAuthorRepo;
import com.example.task15.repos.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/add")
public class AddingController {

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private Service service;

    @GetMapping("/gameAuthor")
    public String addGameAuthor(@RequestParam("name") String name, Model m) {
        boolean check = service.addGameAuthor(name);
        if(check) {
            m.addAttribute("message", "Game Author " + name + " has been created");
            emailSenderService.sendEmail("grisha101202@yandex.ru", "task21", "Game Author " + name + " has been created");
        }
        else {
            m.addAttribute("message", "Game Author with name " + name + " already exits");
            emailSenderService.sendEmail("grisha101202@yandex.ru", "task21", "Game Author with name " + name + " already exits");
        }
        return "home";
    }

    @GetMapping("/game")
    public String addGame(@RequestParam("nameAuthor") String nameAuthor,
                          @RequestParam("name") String name,
                          @RequestParam("creationDate") String date, Model m) {
       boolean check = service.addGame(nameAuthor, name,date);
       if(check) {
           m.addAttribute("message", "Game with name " + name + " add to game author "  + nameAuthor);
           emailSenderService.sendEmail("grisha101202@yandex.ru", "task21", "Game with name " + name + " add to game author "  + nameAuthor);
       }
       else {
           m.addAttribute("message", "Game author with name " + nameAuthor + " is not exists");
           emailSenderService.sendEmail("grisha101202@yandex.ru", "task21", "Game author with name " + nameAuthor + " is not exists");
       }
           return "home";
    }
}
