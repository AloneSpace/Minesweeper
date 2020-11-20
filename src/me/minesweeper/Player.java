package me.minesweeper;

/**
 * เป็น Class สำหรับเก็บ Attribute ของผู้เล่นโดยเฉพาะ
 */
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

    /**
     * เพิ่มจำนวนรอบที่ผู้เล่นเลือกตำแหน่งโดยที่ไม่โดนระเบิด
     */
    public void increasePickup() {
        pickup++;
    }

    /**
     * เพิ่มจำนวนรอบที่ผู้เล่นเลือกตำแหน่งโดยที่โดนระเบิด
     */
    public void increaseBombPickup() {
        bombPickup++;
    }

    /**
     * บันทึกชื่อผู้เล่น
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
