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
            System.out.print("Enter how many of bomb ( 1 - 24 ) => ");
            String qty = scanner.next();
            if(qty.matches("-?\\d+(\\.\\d+)?")) {
                int qty2Int = Integer.parseInt(qty);
                if(qty2Int <= 0 || qty2Int > 24)  {
                    System.out.println("\n-----------------------------------------");
                    System.out.println("|\tError => Out of range input 1 to 24\t|");
                    System.out.println("-----------------------------------------\n");
                    continue;
                }
                bomb.setQTYBomb(qty2Int);
                break;
            }
            System.out.println("\n-------------------------------------");
            System.out.println("|\tError => Please input number\t|");
            System.out.println("-------------------------------------\n");
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
        int position2Int;
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter position ( -1 to exit game ) => ");
            String position = scanner.next();
            if(position.matches("-?\\d+(\\.\\d+)?")) {
                position2Int = Integer.parseInt(position);
                if(position2Int == -1) break;
                if(position2Int <= 0 || position2Int > 25) {
                    System.out.println("\n-----------------------------------------");
                    System.out.println("|\tError => Out of range input 1 to 25\t|");
                    System.out.println("-----------------------------------------\n");
                    continue;
                }
                boolean isSamePosition = table.isSamePosition(position2Int);
                if(isSamePosition) {
                    System.out.println("\n-----------------------------------------");
                    System.out.println("|\tError => You select same position\t|");
                    System.out.println("-----------------------------------------\n");
                    continue;
                }
                table.selectPosition(menu, bomb, position2Int);
                break;
            }
            System.out.println("\n-------------------------------------");
            System.out.println("|\tError => Please input number ( 1 - 25 )\t|");
            System.out.println("-------------------------------------\n");
        }
        return position2Int;
    }
}
