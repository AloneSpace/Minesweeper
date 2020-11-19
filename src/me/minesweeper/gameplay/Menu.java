package me.minesweeper.gameplay;

import me.minesweeper.Player;
import me.minesweeper.utils.Calculate;
import me.minesweeper.utils.Status;

/**
 * Class Menu เป็นคลาสที่ทำหน้าที่ Interact กับ User โดยตรง เปรียบเสมือน FrontEnd
 */
public class Menu {

    /**
     * หน้านี้เปรียบเสมอหน้า GameMenu เพื่อเข้าสู่การเล่นเกม
     */
    public void gameMenu(boolean firstTime, Input input, Player player, Bomb bomb) {
        if(firstTime) input.inputPlayerName(player);
        player.increaseGamePlayed();
        String welcomeMsg = "\n=> Welcome " + player.getPlayerName() + " ( Round #" + player.getGamePlayed() + " )";
        input.inputBomb(bomb);
        bomb.randBombDropPosition();
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
            int position = input.inputPosition(table, player, bomb);
            if(position == -1) {
                table.printSummaryTable(bomb, position);
                gameStatus(bomb, "You exit the game.", Status.EXIT);
                break;
            }
            boolean isBombDropPosition = bomb.isBombDropPosition(position);
            boolean isEndSelected = table.isEndSelected(bomb);
            if(isEndSelected) {
                player.increaseGameWin();
                table.printSummaryTable(bomb, position);
                gameStatus(bomb, "No bomb has been selected.", Status.WIN);
                playAgain = input.inputPlayAgain();
                if(playAgain.equals("Y")|| playAgain.equals("y")) gameMenu(false, input, player, bomb);
                else playerStatus(player);
                break;
            }
            if(isBombDropPosition) {
                table.printSummaryTable(bomb, position);
                gameStatus(bomb, "Gotcha the bomb here.", Status.LOSE);
                playAgain = input.inputPlayAgain();
                if(playAgain.equals("Y")|| playAgain.equals("y")) gameMenu(false, input, player, bomb);
                else playerStatus(player);
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

    /**
     * @param player รับ Object Player เพื่อดึงข้อมูลจาก player
     */
    public void playerStatus(Player player) {
        Calculate calculate = new Calculate();
        double avg_safePickup = calculate.calPickupSafePositionPercentage(player.getPickup(), player.getBombPickup());
        double avg_win = calculate.calWinPercentage(player.getGamePlayed(), player.getGameWin());
        double avg_lose = calculate.calLosePercentage(player.getGamePlayed(), player.getGameLose());

        System.out.println("\n\n=============== [ " + player.getPlayerName() + "'s Info ]===============\n\n");
        System.out.println("Game Played => " + player.getGamePlayed() + "\tAvg. Pickup ( Safe Position) => " + String.format("%.2f", avg_safePickup));
        System.out.println("Game Win => " + player.getGameWin() + "\t\tAvg. Win => " + String.format("%.2f", avg_win));
        System.out.println("Game Lose => " + player.getGameLose() + "\t\tAvg. Lose => " + String.format("%.2f", avg_lose));
    }

}
