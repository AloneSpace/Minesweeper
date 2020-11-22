package me.minesweeper;

import me.minesweeper.gameplay.Controller;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------------------------------");
        System.out.println("|                                |");
        System.out.println("|                                |");
        System.out.println("|          MineSweeper           |");
        System.out.println("|                                |");
        System.out.println("|                                |");
        System.out.println("----------------------------------\n");
        Controller controller = new Controller();
        controller.getMenu().gameMenu(true, controller.getInput(), controller.getPlayer(), controller.getBomb());
    }
}
