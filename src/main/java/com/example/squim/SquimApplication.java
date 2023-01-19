package com.example.squim;

import com.example.squim.model.Player;
import com.example.squim.model.Row;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class SquimApplication {

    public static void main(String[] args) {
        SpringApplication.run(SquimApplication.class, args);

        /*
        Player player = new Player();
        ArrayList<Row> board = new ArrayList<>();
        board.add(new Row(1));
        board.add(new Row(3));
        board.add(new Row(5));
        board.add(new Row(7));

        System.out.println("Board: ");
        for (Row row : board) {
            System.out.println(row.getCount());
        }

        for (int i = 0; i < 9; i++) {
            System.out.println("Turn " + i);
            board = player.takeTurn(board);
            System.out.println("Board: ");
            for (Row row : board) {
                System.out.println(row.getCount());
            }
        }
        */
    }
}
