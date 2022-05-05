package com.example.task14;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/showing")
@Controller
public class ShowingController {
    @GetMapping("/gameauthor")
    public String showGameAuthor(@RequestParam("name") String name, Model m) {
        GameAuthor gameAuthor = ServiceDAO.findGameAuthorByName(name);
        if (gameAuthor == null) {
            m.addAttribute("message", "Game author with name " + gameAuthor + " is not exits");
        } else
            m.addAttribute("message", "Information about game author with name " + name + ": \n" + gameAuthor.toString());
        return "home";
    }

    @GetMapping("/game")
    public String showGame(@RequestParam("nameAuthor") String nameAuthor,
                           @RequestParam("name") String name, Model m) {
        GameAuthor gameAuthor = ServiceDAO.findGameAuthorByName(nameAuthor);
        if (gameAuthor == null) {
            m.addAttribute("message", "Game author with name " + name + " is not exits");
        }
        Game game = gameAuthor.getGameByName(name);
        if (game == null) {
            m.addAttribute("message", "Game with name " + name + " is not exits");
        } else {
            m.addAttribute("message", "Information about game with name " + name + game.toString());
        }
        return "home";
    }


}
