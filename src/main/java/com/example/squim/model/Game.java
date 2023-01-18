package com.example.squim.model;

import java.util.ArrayList;

public class Game {
    int id;
    ArrayList<Row> rows;
    Player[] players;
    int CurrentPlayer;

    public Game(int id, Player[] players) {
        this.rows = rows;
        this.players = players;

    }

    public void deleteFromRow(int rowIndex, int rockIndex) {

    }

    public void takeTurn() {

    }

    public boolean checkEnd() {
        return false;
    }
}
