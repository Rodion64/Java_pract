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
@RequestMapping("/delete")
public class DeletingController {

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private Service service;


    @GetMapping("/gameAuthor")
    public String deleteGameAuthor(@RequestParam("name") String name, Model m)  {
       boolean check = service.deleteGameAuthor(name);
       if(check) {
           m.addAttribute("message", "Game author with name "+ name + "deleted");
           emailSenderService.sendEmail("grisha101202@yandex.ru", "task21", "Game author with name "+ name + "deleted");
       }
       else {
           m.addAttribute("message", "Game author with name" + name + " is not exits");
           emailSenderService.sendEmail("grisha101202@yandex.ru", "task21", "Game author with name" + name + " is not exits");
       }
       return "home";
    }

    @GetMapping("/game")
    public String deleteGame(@RequestParam("name") String name, Model m) {
            boolean check = service.deleteGame(name);
            if(check) m.addAttribute("message", "Game with name " + name + " deleted");
            else {
                m.addAttribute("message", "Game is not exists");
                emailSenderService.sendEmail("grisha101202@yandex.ru", "task21", "Game is not exists");
            }
            return "home";
    }
}
