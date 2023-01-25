package com.example.squim.controller.rest;

import com.example.squim.controller.GameController;
import com.example.squim.model.Difficulty;
import com.example.squim.model.Game;
import com.example.squim.model.Player;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class RESTController {

    Logger logger = org.slf4j.LoggerFactory.getLogger(RESTController.class);

    @GetMapping("/createGame")
    public String createGame(@RequestBody Player[] playerNames, HttpServletResponse response) {
        /*
         * Players should be sent in this format:
         * {
         *  "players": [
         *   {
         *    "name": "player1",
         *    "isHuman": Boolean
         *  },
         *  {
         *   "name": "player2",
         *   "isHuman": Boolean
         *  }
         * ]
         * }
         */
        Game game = GameController.createGame(playerNames);
        Cookie gameCookie = game.getAsCookie();
        response.addCookie(gameCookie);
        return "Game created";
    }

    @GetMapping("/updateGame")
    public String updateGame(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        logger.info("Cookies: " + cookies);
        for (int i = 0; i < cookies.length; i++) {
            if(cookies[i].getAttributes().containsKey("rows")){
                Game game = new Game();
                Difficulty.valueOf("Easy");
                game = new Game(Integer.parseInt(cookies[i].getAttribute("id")),game.convertJsonToRows(cookies[i].getAttribute("rows"))
                        ,Integer.parseInt(cookies[i].getAttribute("currentPlayer")), Difficulty.valueOf(cookies[i].getAttribute("Difficulty")));
                GameController.updateGame(game);
            }
        }
        return "Game updated";
    }
}
