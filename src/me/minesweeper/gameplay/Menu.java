package me.minesweeper.gameplay;

import me.minesweeper.Player;
import me.minesweeper.utils.Status;

public class Menu {

    /**
     * หน้านี้เปรียบเสมอหน้า GameMenu เพื่อเข้าสู่การเล่นเกม
     */
    public void gameMenu(boolean firstTime, Input input, Player player, Bomb bomb) {
        if(firstTime) input.inputPlayerName(player);
        String welcomeMsg = "\n=> Welcome " + player.getPlayerName() + " ( Round #" + player.getGamePlayed() + " )";
        input.inputBomb(bomb);
        bomb.randBombDropPosition();
        player.increaseGamePlayed();
        System.out.println(welcomeMsg);
        startGame(input, player, bomb);
    }

    /**
     * @param input รับ Object Input เพื่อใช้สำหรับรับค่าจากแป้นคีย์บอร์ด
     * @param player รับ Object Player เพื่อใช้สำหรับค่าจากแป้นคีย์บอร์ด
     * @param bomb รับ Object Bomb เพื่อใช้สำหรับค่าจากแป้นคีย์บอร์ด
     */
    public void startGame(Input input, Player player, Bomb bomb) {
        Table table = new Table();
        String playAgain = "";
        while(true) {
            table.printTable();
            int position = input.inputPosition(table, bomb);
            if(position == -1) {
                gameStatus(bomb, "You exit the game.", Status.EXIT);
                break;
            }
            boolean isBombDropPosition = bomb.isBombDropPosition(position);
            boolean isEndSelected = table.isEndSelected(bomb);
            if(isEndSelected) {
                gameStatus(bomb, "No bomb has been selected.", Status.WIN);
                playAgain = input.inputPlayAgain();
                if(playAgain.equals("Y")|| playAgain.equals("y")) gameMenu(false, input, player, bomb);
                break;
            }
            if(isBombDropPosition) {
                gameStatus(bomb, "Gotcha the bomb here.", Status.LOSE);
                playAgain = input.inputPlayAgain();
                if(playAgain.equals("Y")|| playAgain.equals("y")) gameMenu(false, input, player, bomb);
                break;
            }
        }

    }

    /**
     * @param bomb รับ Object Bomb เพื่อตรวจดูว่า ที่ไหนมีระเบิดและไม่มีระเบิด
     */
    public void gameStatus(Bomb bomb, String message, Status status) {
        System.out.println("\n\n=============== [ " + status + " ]===============");
        System.out.println("\n" + message);
        System.out.println("All position of bomb => " + bomb.getBombDrop());
        System.out.println("Safe position => " + bomb.getSafePosition());
        System.out.println();
        bomb.randBombDropPosition();
    }
}
