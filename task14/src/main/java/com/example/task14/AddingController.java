package com.example.task14;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/add")
public class AddingController {
    @GetMapping("/gameauthor")
    public String addGameAuthor(@RequestParam("name") String name, Model m) {
        GameAuthor gameAuthor = new GameAuthor(name);
        boolean addCheck = ServiceDAO.addGameAuthor(gameAuthor);
        if (addCheck) {
            m.addAttribute("message", "Game Author " + gameAuthor.getName() + " has been created");
        } else m.addAttribute("message", "Game Author with name " + gameAuthor.getName() + " already exists");
        return "home";
    }


    @GetMapping("/game")
    public String addGame(@RequestParam("nameAuthor") String nameAuthor,
                          @RequestParam("name") String name,
                          @RequestParam("creationDate") String date, Model m) {
        GameAuthor gameAuthorCheck = ServiceDAO.findGameAuthorByName(nameAuthor);
        if (gameAuthorCheck == null) {
            m.addAttribute("message","Game author with name " + nameAuthor + " is not exits");
        }
        gameAuthorCheck.addGame(new Game(name, date));
        m.addAttribute("message","Game with name " + name + " has been created and enters to " + gameAuthorCheck.getName() + " game author");
        return "home";
    }
}
