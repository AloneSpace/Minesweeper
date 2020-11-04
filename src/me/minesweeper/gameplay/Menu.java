package me.minesweeper.gameplay;

import me.minesweeper.Player;
import me.minesweeper.utils.Status;

public class Menu {

    /**
     * หน้านี้เปรียบเสมอหน้า GameMenu เพื่อเข้าสู่การเล่นเกม
     */
    public void gameMenu(Input input, Player player, Bomb bomb) {
        input.inputPlayerName(player);
        input.inputBomb(bomb);
        startGame(input, player, bomb);
    }
    
    public void startGame(Input input, Player player, Bomb bomb) {
        Table table = new Table();
        String playAgain = "Y";
        String welcomeMsg = "\n=> Welcome " + player.getPlayerName() + " ( Round #" + player.getGamePlayed() + " )";
        bomb.randBombDropPosition();
        while(playAgain.equals("Y")|| playAgain.equals("y")) {
            System.out.println(welcomeMsg);
            table.printTable();
            int position = input.inputPosition(table, bomb);
            boolean isBombDropPosition = bomb.isBombDropPosition(position);
            if(isBombDropPosition) {
                System.out.println("\n\n=============== [ " + Status.LOSE + " ]===============");
                System.out.println("\nGotcha the bomb here.");
                System.out.println("All position of bomb => " + bomb.getBombDrop());
                System.out.println("Safety position => " + bomb.getSafePosition());
                playAgain = input.inputPlayAgain();
            }
        }

    }
}
