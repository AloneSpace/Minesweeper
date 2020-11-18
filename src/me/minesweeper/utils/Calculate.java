package me.minesweeper.utils;

public class Calculate {

    /**
     * @param pickup จำนวนครั้งทั้งหมดที่ผู้เล่นกด
     * @param bombPickup จำนวนครั้งที่ผู้เล่นกดโดนระเบิด
     * @return double: Percentage ค่าเฉลี่ยจำนวนที่กดถูก
     */
    public double calPickupSafePositionPercentage(int pickup, int bombPickup) {
        return ((pickup - bombPickup) / (double) pickup) * 100;
    }

    /**
     * @param gamePlayed จำนวนรอบที่เล่นทั้งหมด
      * @param gameWin จำนวนรอบที่ชนะ
     * @return double: Percentage ค่าเฉลี่ยจำนวนที่ผู้เล่นชนะ
     */
    public double calWinPercentage(int gamePlayed, int gameWin) {
        return (double) (gameWin / gamePlayed) * 100;
    }

    /**
     * @param gamePlayed จำนวนรอบที่เล่นทั้งหมด
     * @param gameLose จำนวนรอบที่แพ้
     * @return double: Percentage ค่าเฉลี่ยจำนวนที่ผู้เล่นแพ้
     */
    public double calLosePercentage(int gamePlayed, int gameLose) {
        return (double) (gameLose / gamePlayed) * 100;
    }
}
