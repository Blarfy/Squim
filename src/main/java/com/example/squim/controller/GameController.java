package com.example.squim.controller;

import com.example.squim.model.Game;
import com.example.squim.model.Player;

import java.util.ArrayList;

public class GameController {
    private static ArrayList<Game> games = new ArrayList<>();

    public GameController() {
        games = new ArrayList<>();
    }

    public static Game createGame(Player[] players){
        Game game = new Game(players);
        games.add(game);
        game.setId(games.indexOf(game));
        return game;
    }

    public static Game updateGame(Game game){
        Game oldGame = findGame(game.getId());
        oldGame.setRows(game.getRows());
        oldGame.setCurrentPlayer(game.getCurrentPlayerInt());
        oldGame.takeTurn();

        return oldGame;
    }

    private static void deleteGame(int id){
        games.remove(findGame(id));
    }

    public static Game findGame(int id){
        Game game = new Game();
        for (Game gameI : games) {
            if (gameI.getId() == id) {
                game = gameI;
            }
        }
        return game;
    }

}
