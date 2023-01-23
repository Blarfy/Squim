package com.example.squim.model;

import com.example.squim.util.CookieUtil;
import jakarta.servlet.http.Cookie;

import java.util.ArrayList;

public class Game {
    int id;
    ArrayList<Row> rows;
    Player[] players;
    int currentPlayer;

    public Game() {
    }

    public Game(Player[] players) {
        setUpBoard();
        this.players = players;

    }
    //update game constructor
    public Game(int id, ArrayList<Row> rows, Player[] players, int currentPlayer) {
        this.id = id;
        this.rows = rows;
        this.players = players;
        this.currentPlayer = currentPlayer;
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
        return players[currentPlayer];
    }

    public int getCurrentPlayerInt(){
        return currentPlayer;
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    public Player[] getPlayers() {
        return players;
    }

    private void setUpBoard(){
        rows.add(new Row(1));
        rows.add(new Row(3));
        rows.add(new Row(5));
        rows.add(new Row(7));
    }

    public Cookie getAsCookie() {
        Cookie gameCookie = CookieUtil.gameToCookie(this);
        return gameCookie;
    }


    public void setRows(ArrayList<Row> rows) {
        this.rows = rows;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


}
