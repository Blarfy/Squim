package com.example.squim;

import com.example.squim.controller.GameController;
import jakarta.servlet.http.Cookie;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @PostMapping("/newGame")
    public void newGame(@RequestBody Cookie gameCookie) {
        //Function is not yet pushed
        //Players needs to be converted to an array
        gameCookie.getAttribute("players");
        //GameController.createGame(gameCookie.getAttribute("id"), gameCookie.getAttribute("players"));
    }

    @PutMapping("/updateGame")
    public void updateGame(@RequestBody Cookie gameCookie) {
        int id = Integer.parseInt(gameCookie.getAttribute("id"));
        //Needs to be converted into an arrayList
        String rows = gameCookie.getAttribute("rows");
        //Needs to be converted into an array
        String players = gameCookie.getAttribute("players");
        String currentPlayer = gameCookie.getAttribute("currentPlayer");

        //Function is not yet pushed
        //GameController.updateGame(id, rows, players, currentPlayer);

    }


}