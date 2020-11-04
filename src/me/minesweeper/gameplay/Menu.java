package me.minesweeper.gameplay;

import me.minesweeper.Player;

import java.util.Scanner;

public class Menu {
    /**
     * หน้านี้เปรียบเสมอหน้า GameMenu เพื่อเข้าสู่การเล่นเกม
     */
    public void gameMenu(Input input, Player player, Bomb bomb) {
        input.inputPlayerName(player);

        input.inputBomb(bomb);
    }
    
    public void startGame() {
        
    }
}
