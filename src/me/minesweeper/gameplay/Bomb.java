package me.minesweeper.gameplay;

import java.util.ArrayList;

/**
 * This Bomb class for store and save bomb data.
 * @author Karunpat
 */
public class Bomb {

    private int qty;
    private ArrayList<Integer> bombDrop;
    private ArrayList<Integer> safePosition;

    /**
     * For check a bomb position.
     * @param position a position for check bomb position.
     * @return true if bomb position equal to position to check. false if bomb position not equal to postion to check.
     */
    public boolean isBombDropPosition(int position) {
        for (int j : bombDrop) {
            if (j == position) return true;
        }
        return false;
    }

    /**
     * Random bombs and store to data.
     */
    public void randBombDropPosition() {
        bombDrop = new ArrayList<>();
        safePosition = new ArrayList<>();
        while (bombDrop.size() < qty) {
            double randomBombDrop = Math.ceil(Math.random() * 25);
            if (!bombDrop.contains((int) randomBombDrop)) {
                bombDrop.add((int) randomBombDrop);
            }
        }
        for(int i = 1; i <= 25; i++) {
            if(!bombDrop.contains(i)) {
                safePosition.add(i);
            }
        }
    }

    /**
     * For check the positions where the bombs are store.
     * @return The positions where the bombs are store.
     */
    public String getBombDrop() {
        return bombDrop.toString();
    }

    /**
     * For check the positions where the safe position.
     * @return The positions where the safe position.
     */
    public String getSafePosition() {
        return safePosition.toString();
    }

    /**
     * For check size of safe positions.
     * @return Size of position of safe position.
     */
    public int getSizeofSafePosition() {
        return safePosition.size();
    }

    /**
     * For save the quantity of bomb.
     * @param qty Quantity of bomb.
     */
    public void setQTYBomb(int qty) {
        this.qty = qty;
    }

}
