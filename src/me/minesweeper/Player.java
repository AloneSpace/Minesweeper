package me.minesweeper;

/**
 * This player class use for save player data.
 * @author Warisara
 */
public class Player {

    private String playerName;
    private int gamePlayed;
    private int gameWin;
    private int pickup;
    private int bombPickup;

    /**
     * For increase round of game when player start new game.
     */
    public void increaseGamePlayed() {
        gamePlayed++;
    }

    /**
     * For increase round of game when player won the game.
     */
    public void increaseGameWin() {
        gameWin++;
    }

    /**
     * For increase round of pickup time when player selected the safe position.
     */
    public void increasePickup() {
        pickup++;
    }

    /**
     * For increase round of pickup time when player selected the bomb position.
     */
    public void increaseBombPickup() {
        bombPickup++;
    }

    /**
     * Save player name.
     * @param playerName for set the player name.
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * Get number of times player pickup safe position.
     * @return number of times player pickup safe position.
     */
    public int getPickup() {
        return pickup;
    }

    /**
     * Get number of times player pickup bomb position.
     * @return number of times player pickup bomb position.
     */
    public int getBombPickup() {
        return bombPickup;
    }

    /**
     * Get player name.
     * @return player name.
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Get number of times player win the game.
     * @return number of times player win the game.
     */
    public int getGameWin() {
        return gameWin;
    }

    /**
     * Get number of times player lose the game.
     * @return number of times player lose the game.
     */
    public int getGameLose() {
        return gamePlayed - gameWin;
    }

    /**
     * Get number of times player play the game.
     * @return number of times player play the game.
     */
    public int getGamePlayed() {
        return gamePlayed;
    }
}
