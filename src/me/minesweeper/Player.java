package me.minesweeper;

public class Player {

    private String playerName;
    private boolean isWin;

    public Player(String playerName) {
        setPlayerName(playerName);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
