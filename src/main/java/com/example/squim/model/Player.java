package com.example.squim.model;

import java.util.ArrayList;

public class Player {
    private boolean isHuman;
    private String name;

    public boolean isHuman() {
        return isHuman;
    }

    public void setHuman(boolean human) {
        isHuman = human;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Row> takeTurn(ArrayList<Row> board) {
        boolean oddOnes = false;
        boolean oddTwos = false;
        boolean oddFours = false;
        for (Row row : board) {

        }
        return board;
    }
}
