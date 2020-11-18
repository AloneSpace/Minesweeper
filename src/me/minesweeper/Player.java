package me.minesweeper;

public class Player {

    private String playerName;
    private int gamePlayed;
    private int gameWin;
    private int pickup;
    private int bombPickup;

    /**
     * เพื่อเพิ่มจำนวนรอบ เมื่อมีการเริ่มเล่นใหม่
     */
    public void increaseGamePlayed() {
        gamePlayed++;
    }

    /**
     * เพื่อเพิ่มจำนวนรอบที่ชนะ
     */
    public void increaseGameWin() {
        gameWin++;
    }

    public void increasePickup() {
        pickup++;
    }

    public void increaseBombPickup() {
        bombPickup++;
    }

    /**
     * @param playerName ใส่ชื่อผู้เล่น
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * @return จำนวนรอบทั้งหมดที่ผู้เล่นเลือก
     */
    public int getPickup() {
        return pickup;
    }

    /**
     * @return จำนวนรอบทั้งหมดที่ผู้เล่นเลือกแล้วโดนระเบิด
     */
    public int getBombPickup() {
        return bombPickup;
    }

    /**
     * @return String: ชื่อผู้เล่น
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @return int: ว่าผู้เล่นมีจำนวนชนะกี่รอบ
     */
    public int getGameWin() {
        return gameWin;
    }

    /**
     * @return int: จำนวน
     */
    public int getGameLose() {
        return gamePlayed - gameWin;
    }

    /**
     * @return int: จำนวนรอบที่เราเล่นทั้งหมด
     */
    public int getGamePlayed() {
        return gamePlayed;
    }
}
