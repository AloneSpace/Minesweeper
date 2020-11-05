package me.minesweeper.gameplay;

import me.minesweeper.Player;

import java.util.Scanner;

public class Input {


    /**
     * สำหรับรับค่าจากแป้นพิมพ์ บันทึกชื่อผู้เล่น
     * @param player รับ Object Player เพื่อเก็บ String PlayerName
     */
    public void inputPlayerName(Player player) {
        Scanner scanner = new Scanner(System.in);
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
        while(true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Enter how many of bomb ( 1 - 25 ) => ");
                int qty = scanner.nextInt();
                if(qty <= 0 || qty > 24)  {
                    System.out.println("\n-----------------------------------------");
                    System.out.println("|\tError => Out of range input 1 to 24\t|");
                    System.out.println("-----------------------------------------\n");
                    continue;
                }
                bomb.setQTYBomb(qty);
                break;
            } catch (Exception e) {
                System.out.println("\n-------------------------------------");
                System.out.println("|\tError => Please input number\t|");
                System.out.println("-------------------------------------\n");
            }
        }
    }

    public String inputPlayAgain() {
        String pick = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Do you want to play again ( Y,y or N,n ) => ");
            pick = scanner.next();
            if((pick.equals("Y") || pick.equals("y") || pick.equals("N") || pick.equals("n"))) break;
            System.out.println("\n---------------------------------------------------------------------");
            System.out.println("|\tError => Please input only one letter ( Y,y = Yes, N,n = No )\t|");
            System.out.println("---------------------------------------------------------------------");
        }
        return pick;
    }

    public int inputPosition(Menu menu, Table table, Bomb bomb) {
        int position = 0;
        while(true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Enter position => ");
                position = scanner.nextInt();
                if(position <= 0 || position > 25)  {
                    System.out.println("\n-----------------------------------------");
                    System.out.println("|\tError => Out of range input 1 to 25\t|");
                    System.out.println("-----------------------------------------\n");
                    continue;
                }
                boolean isSamePosition = table.isSamePosition(position);
                if(isSamePosition) {
                    System.out.println("\n-----------------------------------------");
                    System.out.println("|\tError => You select same position\t|");
                    System.out.println("-----------------------------------------\n");
                    continue;
                }
                table.selectPosition(menu, bomb, position);
                break;
            } catch (Exception e) {
                System.out.println("\n-------------------------------------");
                System.out.println("|\tError => Please input number ( 1 - 25 )\t|");
                System.out.println("-------------------------------------\n");
            }
        }

        return position;
    }
}
