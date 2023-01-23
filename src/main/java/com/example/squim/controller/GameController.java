package com.example.squim.controller;

import com.example.squim.model.Game;
import com.example.squim.model.Player;

import java.util.ArrayList;

public class GameController {
    private static ArrayList<Game> games;

    public GameController() {
        games = new ArrayList<>();
    }

    public static void createGame(int id, Player[] players){
        Game game = new Game(id, players);
        games.add(game);
    }

    public static void updateGame(){

    }

    private static void deleteGame(){

    }

    private static Game findGame(int id){
        for (int i = 0; i < games.size(); i++) {
            if(games.get(i).getId()==id){
                return games.get(i);
            }
        }
        
    }

}
