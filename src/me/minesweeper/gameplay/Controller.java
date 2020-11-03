package me.minesweeper.gameplay;

import me.minesweeper.Player;
public class Controller {

    private final Menu menu;
    private final Input input;
    private final Bomb bomb;
    private final Player player;

    public Controller() {
        menu = new Menu();
        input = new Input();
        bomb = new Bomb();
        player = new Player();
    }

    public Menu getMenu() {
        return menu;
    }

    public Input getInput() {
        return input;
    }

    public Bomb getBomb() {
        return bomb;
    }

    public Player getPlayer() {
        return player;
    }
}
