package me.minesweeper.gameplay;

import me.minesweeper.Player;

import java.util.Scanner;

public class Input {

    private final Scanner scanner = new Scanner(System.in);

    public void inputPlayerName(Player player) {
        String playerName = scanner.next();
        player.setPlayerName(playerName);
    }

    public void inputBomb(Bomb bomb) {
        int qty = scanner.nextInt();
        bomb.setQTYBomb(qty);
    }
}
