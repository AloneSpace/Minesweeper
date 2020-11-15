package me.minesweeper;

public class Player {

    private String playerName;
    private int gamePlayed;
    private int gameWin;

    public Player() {
        increaseGamePlayed();
    }

    /**
     * @return String: ชื่อผู้เล่น
     */
    public String getPlayerName() {
        return playerName;
    }

    public int getGameWin() {
        return gameWin;
    }

    /**
     * @return int: จำนวนรอบที่เราเล่นทั้งหมด
     */
    public int getGamePlayed() {
        return gamePlayed;
    }

    /**
     * เพื่อเพิ่มจำนวนรอบ เมื่อมีการเริ่มเล่นใหม่
     */
    public void increaseGamePlayed() {
        gamePlayed++;
    }

    /**
     * @param playerName ใส่ชื่อผู้เล่น
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
