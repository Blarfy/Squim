package com.example.squim.util;

import com.example.squim.model.Game;
import jakarta.servlet.http.Cookie;

public class CookieUtil
{
    public static Cookie gameToCookie(Game game){
        Cookie gameCookie = new Cookie("id", game.getId() + "");
        gameCookie.setAttribute("rows", game.getRowsAsJson());
        gameCookie.setAttribute("players", game.getPlayersAsJson());
        gameCookie.setAttribute("currentPlayer", game.getCurrentPlayer().getName());
        return gameCookie;
    }
}
