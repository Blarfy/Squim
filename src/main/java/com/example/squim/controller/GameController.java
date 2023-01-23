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

    public static void updateGame(Game game){
        Game oldGame = findGame(game.getId());
        oldGame.setRows(game.getRows());
        oldGame.setPlayers(game.getPlayers());
        oldGame.setCurrentPlayer(game.getCurrentPlayerInt());
    }

    private static void deleteGame(int id){
        games.remove(findGame(id));
    }

    private static Game findGame(int id){
        Game game = new Game();
        for (int i = 0; i < games.size(); i++) {
            if(games.get(i).getId()==id){
                game = games.get(i);
            }
        }
        return game;
    }

}
