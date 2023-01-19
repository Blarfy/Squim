package com.example.squim.model;

public class Row {

    private int count;

    private boolean[] rocks;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setRocks(boolean[] rocks) {
        this.rocks = rocks;
    }

    public Row(int count) {
        this.count = count;
        this.rocks = new boolean[count];
        for (int i = 0; i < count; i++) {
            rocks[i] = true;
        }
    }

    public boolean[] getRocks() {
        //TODO please create this method. It should return the rocks array.
        return rocks;
    }
}
