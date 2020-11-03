package me.minesweeper.gameplay;

import me.minesweeper.Player;

import java.util.Scanner;

public class Menu {
    /**
     * หน้านี้เปรียบเสมอหน้า GameMenu เพื่อเข้าสู่การเล่นเกม
     */
    public void gameMenu(Input input, Player player, Bomb bomb) {
        System.out.print("Enter your name => ");
        input.inputPlayerName(player);
        System.out.print("Enter how many of bomb => ");
        input.inputBomb(bomb);
    }
    
    public void startGame() {
        
    }
}
