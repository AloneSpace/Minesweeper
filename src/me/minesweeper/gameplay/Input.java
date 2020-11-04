package me.minesweeper.gameplay;

import me.minesweeper.Player;

import java.util.Scanner;

public class Input {

    private final Scanner scanner = new Scanner(System.in);

    /**
     * สำหรับรับค่าจากแป้นพิมพ์ บันทึกชื่อผู้เล่น
     * @param player รับ Object Player เพื่อเก็บ String PlayerName
     */
    public void inputPlayerName(Player player) {
        String playerName = "";
        System.out.print("Enter your name => ");
        playerName += scanner.nextLine();
        player.setPlayerName(playerName);
    }

    /**
     * สำหรับรับค่าจากแป้นพิมพ์ บันทึกจำนวนระเบิด
     * @param bomb รับ Object Bomb เพื่อเก็บจำนวนระเบิด
     */
    public void inputBomb(Bomb bomb) {
        try {
            System.out.print("Enter how many of bomb => ");
            int qty = scanner.nextInt();
            bomb.setQTYBomb(qty);
        } catch (Exception e) {
            System.out.println("\n-------------------------------------");
            System.out.println("|\tError => Please input number\t|");
            System.out.println("-------------------------------------\n");
            scanner.nextLine();
            inputBomb(bomb);
        }
    }
}
