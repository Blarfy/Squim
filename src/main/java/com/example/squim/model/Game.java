package com.example.squim.model;

import java.util.ArrayList;

public class Game {
    int id;
    ArrayList<Row> rows;
    Player[] players;
    int CurrentPlayer;

    public Game(int id, Player[] players) {
        this.id = id;
        this.players = players;
        setUpBoard();
    }

    public void deleteFromRow(int rowIndex, int rockIndex) {
        rows.get(rowIndex).deleteRock(rockIndex);
    }

    public void takeTurn() {

    }

    public boolean checkEnd() {
        return false;
    }

    private void setUpBoard(){
        rows.add(new Row(1));
        rows.add(new Row(3));
        rows.add(new Row(5));
        rows.add(new Row(7));
    }
}
