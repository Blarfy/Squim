package com.example.squim.model;

import java.util.ArrayList;

public class Player {
    private boolean isHuman;
    private String name;

    public boolean getIsHuman() {
        return isHuman;
    }

    public void setIsHuman(boolean human) {
        isHuman = human;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Row> takeTurn(ArrayList<Row> board, float failChance) {
        boolean oddOnes = false;
        boolean oddTwos = false;
        boolean oddFours = false;

        //get random number between 0 and 1 and compare with failchance
        if (Math.random() < failChance) {
            for (Row row : board) {
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
            for (Row row : board) {
                if (row.getCount() >= 1){
                    // take one
                    row.setCount(row.getCount() - 1);
                    System.out.println("Player took 1 from row " + board.indexOf(row));
                    break;
                }
            }
        } else if (oddTwos) {
            for (Row row : board) {
                if (row.getCount() >= 2){
                    // take two
                    row.setCount(row.getCount() - 2);
                    System.out.println("Player took 2 from row " + board.indexOf(row));
                    break;
                }
            }
        } else if (oddFours) {
            for (Row row : board) {
                if (row.getCount() >= 4){
                    // take two
                    row.setCount(row.getCount() - 2);
                    System.out.println("Player took 4 from row " + board.indexOf(row));
                    break;
                }
            }
        } else {
            boolean randMove = false;
            while(!randMove){
                int randRow = (int) (Math.random() * board.size());
                if (board.get(randRow).getCount() % 2 == 1 || board.get(randRow).getCount() == 2){
                    board.get(randRow).setCount(board.get(randRow).getCount() - 1);
                    System.out.println("Player took 1 from row " + randRow);
                    randMove = true;
                } else if (board.get(randRow).getCount() > 2){
                    board.get(randRow).setCount(board.get(randRow).getCount() - 2);
                    System.out.println("Player took 2 from row " + randRow);
                    randMove = true;
                }
            }
        }
        return board;
    }
}
