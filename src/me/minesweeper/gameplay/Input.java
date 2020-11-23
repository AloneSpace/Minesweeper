package me.minesweeper.gameplay;

import me.minesweeper.Player;

import java.util.Scanner;

/**
 * The Input class use for let user input data and send to another class.
 * @author Nopphasorn
 */
public class Input {


    /**
     * Let user input player name.
     * @param player This player object use for set player name.
     */
    public void inputPlayerName(Player player) {
        Scanner scanner = new Scanner(System.in);
        String playerName = "";
        System.out.print("Enter your name => ");
        playerName += scanner.nextLine();
        player.setPlayerName(playerName);
    }

    /**
     * Let user input quantity bomb.
     * @param bomb This bomb object use for set quantity bomb.
     */
    public void inputBomb(Bomb bomb) {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter how many of bomb ( 1 - 24 ) => ");
            String qty = scanner.next();
            if(qty.matches("-?\\d+(\\d+)?")) {
                int qty2Int = Integer.parseInt(qty);
                if(qty2Int <= 0 || qty2Int > 24)  {
                    System.out.println("\n---------------------------------------------");
                    System.out.println("|    Error => Out of range input 1 to 24    |");
                    System.out.println("---------------------------------------------\n");
                    continue;
                }
                bomb.setQTYBomb(qty2Int);
                break;
            }
            System.out.println("\n-------------------------------------------------");
            System.out.println("|    Error => Please input number ( 1 - 24 )    |");
            System.out.println("-------------------------------------------------\n");
        }
    }

    /**
     * Ask user for want to play again.
     * @return Answer whether to play or not.
     */
    public String inputPlayAgain() {
        String pick = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Do you want to play again ( Y,y or N,n ) => ");
            pick = scanner.next();
            if((pick.equals("Y") || pick.equals("y") || pick.equals("N") || pick.equals("n"))) break;
            System.out.println("\n-------------------------------------------------------------------------");
            System.out.println("|     Error => Please input only one letter ( Y,y = Yes, N,n = No )     |");
            System.out.println("-------------------------------------------------------------------------");
        }
        return pick;
    }

    /**
     * Let user input the position.
     * @param table The table class use for set the position.
     * @param player The player class use send player information to another class.
     * @param bomb The bomb class use for check if the position same as bomb position.
     * @return The position where player selected.
     */
    public int inputPosition(Table table, Player player, Bomb bomb) {
        int position2Int;
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter position ( -1 to exit game ) => ");
            String position = scanner.next();
            if(position.matches("-?\\d+(\\d+)?")) {
                position2Int = Integer.parseInt(position);
                if(position2Int == -1) break;
                if(position2Int <= 0 || position2Int > 25) {
                    System.out.println("\n-----------------------------------------------");
                    System.out.println("|     Error => Out of range input 1 to 25     |");
                    System.out.println("-----------------------------------------------\n");
                    continue;
                }
                boolean isSamePosition = table.isSamePosition(position2Int);
                if(isSamePosition) {
                    System.out.println("\n---------------------------------------------");
                    System.out.println("|     Error => You select same position     |");
                    System.out.println("---------------------------------------------\n");
                    continue;
                }
                table.selectPosition(bomb, player, position2Int);
                break;
            }
            System.out.println("\n---------------------------------------------------");
            System.out.println("|     Error => Please input number ( 1 - 25 )     |");
            System.out.println("---------------------------------------------------\n");
        }
        return position2Int;
    }
}
