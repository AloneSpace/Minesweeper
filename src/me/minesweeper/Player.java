package me.minesweeper;

public class Player {

    private String playerName;
    private int gamePlayed;
    private int gameWin;
    private boolean isWin;

    public Player() {
        gamePlayed++;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getGameWin() {
        return gameWin;
    }

    public int getGamePlayed() {
        return gamePlayed;
    }

    public void increaseGamePlayed() {
        gamePlayed++;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
