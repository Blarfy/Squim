package com.example.squim.model;

import com.example.squim.util.CookieUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.Cookie;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    //this annotation is used to prevent the id from being sent to the client. It should only be stored in a cookie
    @JsonIgnore
    int id;
    ArrayList<Row> rows;
    Player[] players;
    int currentPlayer;

    Difficulty difficulty = Difficulty.NORMAL;

    public Game() {
    }

    public Game(Player[] players) {
        setUpBoard();
        this.players = players;
    }
    //update game constructor
    public Game(int id, ArrayList<Row> rows, int currentPlayer, Difficulty difficulty) {
        this.id = id;
        this.rows = rows;
        this.players = players;
        this.currentPlayer = currentPlayer;
        this.difficulty = difficulty;
    }

    public void deleteFromRow(int rowIndex, int rockIndex) {
        rows.get(rowIndex).deleteRock(rockIndex);
    }

    public void takeTurn() {
        //if ai is playing, do aiTurn

        float failChance = .3f;
        switch (difficulty) {
            case EASY:
                failChance = .5f;
                break;
            case NORMAL:
                failChance = .3f;
                break;
            case HARD:
                failChance = .1f;
                break;
        }

        if(!players[currentPlayer].getIsHuman()){
            aiTurn(failChance);
        }

        //change whose turn it is
        if (currentPlayer == 0) {
            currentPlayer = 1;
        } else {
            currentPlayer = 0;
        }
        checkEnd();
    }

    public void aiTurn(float failChance) {
        boolean oddOnes = false;
        boolean oddTwos = false;
        boolean oddFours = false;

        //check if total rocks is lower than 5
        int totalRocks = 0;
        for (Row row : rows) {
            totalRocks += row.getCount();
        }

        //maybe put failchance here as well if endgame is too difficult for user
        if(totalRocks > 5) {

            //get random number between 0 and 1 and compare with failchance
            if (Math.random() < failChance) {
                for (Row row : rows) {
                    int tempCount = row.getCount();
                    if (row.getCount() % 2 == 1) {
                        oddOnes = !oddOnes;
                        tempCount--;
                    }
                    while (tempCount >= 4) {
                        oddFours = !oddFours;
                        tempCount -= 4;
                    }
                    while (tempCount >= 2) {
                        oddTwos = !oddTwos;
                        tempCount -= 2;
                    }
                }
            } else System.out.println("Failed to calculate odds!");

            if (oddOnes) {
                for (Row row : rows) {
                    if (row.getCount() >= 1) {
                        // take one
                        row.aiDeleteRock(1);
                        System.out.println("Player took 1 from row " + rows.indexOf(row));
                        break;
                    }
                }
            } else if (oddTwos) {
                for (Row row : rows) {
                    if (row.getCount() >= 2) {
                        // take two
                        row.aiDeleteRock(2);
                        System.out.println("Player took 2 from row " + rows.indexOf(row));
                        break;
                    }
                }
            } else if (oddFours) {
                for (Row row : rows) {
                    if (row.getCount() >= 4) {
                        // take two
                        row.aiDeleteRock(2);
                        System.out.println("Player took 4 from row " + rows.indexOf(row));
                        break;
                    }
                }
            } else {
                boolean randMove = false;
                while (!randMove) {
                    int randRow = (int) (Math.random() * rows.size());
                    if (rows.get(randRow).getCount() % 2 == 1 || rows.get(randRow).getCount() == 2) {
                        rows.get(randRow).aiDeleteRock(1);
                        System.out.println("Player took 1 from row " + randRow);
                        randMove = true;
                    } else if (rows.get(randRow).getCount() > 2) {
                        rows.get(randRow).aiDeleteRock(2);
                        System.out.println("Player took 2 from row " + randRow);
                        randMove = true;
                    }
                }
            }
        } else {
            //if total rocks is less than 5, try to make other player take the last rock
            int movesleft = 0;
            for (Row row : rows) {
                movesleft += row.getCount() / 2;
                if(row.getCount() % 2 == 1) movesleft++;
            }
            if(movesleft % 2 == 1){
                //take one move
                for (Row row : rows) {
                    if (row.getCount() % 2 == 1) {
                        // take one
                        row.aiDeleteRock(1);
                        System.out.println("Player took 1 from row " + rows.indexOf(row));
                        break;
                    } else if (row.getCount() >= 2) {
                        // take two
                        row.aiDeleteRock(2);
                        System.out.println("Player took 2 from row " + rows.indexOf(row));
                        break;
                    }
                }
            } else {
                //take half a move
                for (Row row : rows) {
                    if (row.getCount() >= 2) {
                        // take one
                        row.aiDeleteRock(1);
                        System.out.println("Player took 2 from row " + rows.indexOf(row));
                        break;
                    } else if (row.getCount() == 1) {
                        // if it cannot be helped, accept defeat
                        row.aiDeleteRock(1);
                        System.out.println("Player took 1 from row " + rows.indexOf(row));
                        break;
                    }
                }
            }
        }
    }

    public boolean checkEnd() {
        boolean end = true;
        for (Row row : rows) {
            if (row.getCount() != 0) {
                end = false;
            }
        }
        return end;
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

    public ArrayList<Row> convertJsonToRows (String json){
        Pattern p = Pattern.compile("([a-z]{4,})");
        Matcher m = p.matcher(json);
        ArrayList<Row> rows = new ArrayList<>();
        Row row1 = new Row(1);
        m.find();
        if(m.group().equals("false")){
            row1.deleteRock(0);
        }
        Row row2 = new Row(3);
        for (int i = 0; i < row2.getCount(); i++) {
            m.find();
            if(m.group().equals("false")){
                row2.deleteRock(i);
            }
        }
        Row row3 = new Row(5);
        for (int i = 0; i < row3.getCount(); i++) {
            m.find();
            if(m.group().equals("false")){
                row3.deleteRock(i);
            }
        }
        Row row4 = new Row(7);
        for (int i = 0; i < row3.getCount(); i++) {
            m.find();
            if(m.group().equals("false")){
                row4.deleteRock(i);
            }
        }
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);
        return rows;
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
        rows = new ArrayList<>();
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

    public void setId(int id) {
        this.id = id;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
