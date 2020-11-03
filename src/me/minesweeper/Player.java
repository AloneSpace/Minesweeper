package me.minesweeper;

import java.util.Scanner;

public class Player {

    private String playerName;
    private int gamePlayed;
    private int gameWin;
    private boolean isWin;

    public Player() {
    }

    public String getPlayerName() {
        return playerName;
    }

    public void inputPlayerName(Scanner scanner) {
        try {
            System.out.print("Enter your name => ");
            playerName = scanner.next();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getGameWin() {
        return gameWin;
    }

    public int getGamePlayed() {
        return gamePlayed;
    }
}
