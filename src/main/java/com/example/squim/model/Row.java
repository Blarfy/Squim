package com.example.squim.model;

import java.util.ArrayList;

public class Row {
    private Integer count;
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
        count--;
        return true;
    }

    public boolean aiDeleteRock(int rocks){
        for(int i = rocks; i > 0; i--){
            if (this.rocks.get(i)){
                this.rocks.set(i,false);
                count--;
            }
        }
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
