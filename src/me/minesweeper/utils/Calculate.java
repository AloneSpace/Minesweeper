package me.minesweeper.utils;

/**
 * This Calculate class for calculate percentage.
 * @author Warisara
 */
public class Calculate {

    /**
     * For calculate percentage number of times the safe position.
     * @param pickup number of times player pickup safe position.
     * @param bombPickup number of times player pickup bomb position.
     * @return Percentage number of times the safe position.
     */
    public double calPickupSafePositionPercentage(int pickup, int bombPickup) {
        return pickup != 0 ? ((pickup - bombPickup) / (double) pickup) * 100 : 0;
    }

    /**
     * For calculate percentage number of times player win the game.
     * @param gamePlayed number of times player play the game.
     * @param gameWin number of times player win the game.
     * @return Percentage number of times player win the game.
     */
    public double calWinPercentage(int gamePlayed, int gameWin) {
        return (gameWin / (double) gamePlayed) * 100;
    }

    /**
     * For calculate percentage number of times player lose the game.
     * @param gamePlayed number of times player play the game.
     * @param gameLose number of times player lose the game.
     * @return Percentage number of times player lose the game.
     */
    public double calLosePercentage(int gamePlayed, int gameLose) {
        return (gameLose / (double) gamePlayed) * 100;
    }
}
