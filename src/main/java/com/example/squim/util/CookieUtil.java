package com.example.squim.util;

import com.example.squim.model.Game;
import com.example.squim.model.Player;
import com.example.squim.model.Row;
import jakarta.servlet.http.Cookie;

import java.util.ArrayList;

import static org.springframework.web.util.WebUtils.getCookie;

public class CookieUtil
{
    public static Cookie gameToCookie(Game game){
        Cookie gameCookie = new Cookie("id", game.getId() + ""); //find a better way and implement it yourself if you want it fixed Alex. this works just fine
//        gameCookie.setAttribute("rows", game.getRowsAsJson());
//        gameCookie.setAttribute("players", game.getPlayersAsJson());
//        gameCookie.setAttribute("currentPlayer", game.getCurrentPlayer().getName());
//        gameCookie.setAttribute("Difficulty",game.getDifficulty().toString());
        gameCookie.setMaxAge(1000000);
        return gameCookie;
    }


}
