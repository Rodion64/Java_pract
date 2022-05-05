package com.example.task14;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/delete")
public class DeletingController {

    @GetMapping("/gameauthor")
    public String deleteGameAuthor(@RequestParam("name") String name, Model m) {
        boolean check = ServiceDAO.deleteGameAuthorByName(name);
        if (check) {
            m.addAttribute("message","Game author with name " + name + " succesfully deleted");
        } else {
            m.addAttribute("message","Game author with name " + name + " is not exits");
        }
        return "home";
    }

    @GetMapping("/game")
    public String deleteGame(@RequestParam("nameAuthor") String nameAuthor, @RequestParam("name") String name, Model m) {
        GameAuthor gameAuthor = ServiceDAO.findGameAuthorByName(nameAuthor);
        if (gameAuthor == null) {
            m.addAttribute("Game author with name " + nameAuthor + " is not exits");
        }
        boolean check = gameAuthor.deleteGame(name);
        if (check) {
            m.addAttribute("message", "Game with name " + name + " succesfully deleted");
        } else {
            m.addAttribute("message","Game with name " + name + " is not exits");
        }
        return "home";
    }
}
