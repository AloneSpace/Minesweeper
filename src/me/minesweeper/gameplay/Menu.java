package me.minesweeper.gameplay;

import me.minesweeper.Player;
import me.minesweeper.utils.Calculate;
import me.minesweeper.utils.Status;

/**
 * The Menu class use for interact with user. Like front-end.
 * @author Karunpat
 */
public class Menu {

    /**
     * For print the monitor of game menu.
     * @param firstTime Use for check if first time or not.
     * @param input Use for input bomb qty.
     * @param player Use for get and set player information.
     * @param bomb Use for random bomb drop position.
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
     * This method use for start the game and send data to another class.
     * @param input Input object use for input data.
     * @param player Player object use for information of player to another object.
     * @param bomb Bomb object use for check the bomb position.
     */
    public void startGame(Input input, Player player, Bomb bomb) {
        Table table = new Table();
        String playAgain = "";
        while(true) {
            table.printTable(bomb);
            int position = input.inputPosition(table, player, bomb);
            if(position == -1) {
                table.printSummaryTable(bomb, position);
                gameStatus(bomb, "You exit the game.", Status.EXIT);
                playerStatus(player);
                break;
            }
            boolean isBombDropPosition = bomb.isBombDropPosition(position);
            boolean isEndSelected = table.isEndSelected(bomb);
            if(isBombDropPosition) {
                table.printSummaryTable(bomb, position);
                gameStatus(bomb, "Gotcha the bomb here.", Status.LOSE);
                playAgain = input.inputPlayAgain();
                if(playAgain.equals("Y")|| playAgain.equals("y")) gameMenu(false, input, player, bomb);
                else playerStatus(player);
                break;
            }
            if(isEndSelected) {
                player.increaseGameWin();
                table.printSummaryTable(bomb, position);
                gameStatus(bomb, "No bomb has been selected.", Status.WIN);
                playAgain = input.inputPlayAgain();
                if(playAgain.equals("Y")|| playAgain.equals("y")) gameMenu(false, input, player, bomb);
                else playerStatus(player);
                break;
            }
        }

    }

    /**
     * This method use for print game status.
     * @param bomb Bomb object use for print safe and bomb position.
     * @param message Print the message.
     * @param status Get the state of game.
     */
    public void gameStatus(Bomb bomb, String message, Status status) {
        System.out.println("\n\n=============== [ " + status + " ]===============");
        System.out.println("\n" + message);
        System.out.println("All position of bomb => " + bomb.getBombDrop());
        System.out.println("Safe position => " + bomb.getSafePosition());
        System.out.println();
    }

    /**
     * The method use for print summary of player.
     * @param player Player object use for receive player information.
     */
    public void playerStatus(Player player) {
        Calculate calculate = new Calculate();
        double avg_safePickup = calculate.calPickupSafePositionPercentage(player.getPickup(), player.getBombPickup());
        double avg_win = calculate.calWinPercentage(player.getGamePlayed(), player.getGameWin());
        double avg_lose = calculate.calLosePercentage(player.getGamePlayed(), player.getGameLose());

        System.out.println("\n\n=============== [ " + player.getPlayerName() + "'s Info ]===============\n\n");
        System.out.println("Game Played => " + player.getGamePlayed() + "\tAvg. Pickup ( Safe Position) => " + String.format("%.2f", avg_safePickup) + "%");
        System.out.println("Game Win => " + player.getGameWin() + "\t\tAvg. Win => " + String.format("%.2f", avg_win) + "%");
        System.out.println("Game Lose => " + player.getGameLose() + "\t\tAvg. Lose => " + String.format("%.2f", avg_lose) + "%");
    }

}
