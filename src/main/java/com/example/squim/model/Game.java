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

    public int getId(){
        return id;
    }

    public String getRowsAsJson(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Row row : rows) {
            sb.append('[');
            for (boolean rock : row.getRocks()) {
                sb.append(rock);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("],");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    public String getPlayersAsJson(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Player player : players) {
            sb.append(player.getName());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    public Player getCurrentPlayer(){
        return players[CurrentPlayer];
    }

    private void setUpBoard(){
        rows.add(new Row(1));
        rows.add(new Row(3));
        rows.add(new Row(5));
        rows.add(new Row(7));
    }
}
