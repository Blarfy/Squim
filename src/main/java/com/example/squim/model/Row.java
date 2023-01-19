package com.example.squim.model;

import java.util.ArrayList;

public class Row {
    private int count;
    private ArrayList<Boolean> rocks;

    public Row(int count) {
        this.count = count;
        rocks = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            rocks.add(true);
        }

    }

    public boolean deleteRock(int rock){
        rocks.set(rock,false);
        return true;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Boolean> getRocks() {
        return rocks;
    }

    public void setRocks(ArrayList<Boolean> rocks) {
        this.rocks = rocks;
    }

}
