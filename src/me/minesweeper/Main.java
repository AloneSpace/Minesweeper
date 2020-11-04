package me.minesweeper;

import me.minesweeper.gameplay.Controller;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------------");
        System.out.println("|\t\t\t\t\t|");
        System.out.println("|\t\t\t\t\t|");
        System.out.println("|\t MineSweeper\t|");
        System.out.println("|\t\t\t\t\t|");
        System.out.println("|\t\t\t\t\t|");
        System.out.println("---------------------\n");
        Controller controller = new Controller();
        controller.getMenu().gameMenu(controller.getInput(), controller.getPlayer(), controller.getBomb());
    }
}
