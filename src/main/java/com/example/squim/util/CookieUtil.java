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
        Cookie gameCookie = new Cookie("id", game.getId() + ""); //FIX this, we shouldn't be casting a string by adding an empty string, this is far from "Best Practices"
        gameCookie.setAttribute("rows", game.getRowsAsJson());
        gameCookie.setAttribute("players", game.getPlayersAsJson());
        gameCookie.setAttribute("currentPlayer", game.getCurrentPlayer().getName());
        return gameCookie;
    }


}
