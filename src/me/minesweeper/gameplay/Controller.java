package me.minesweeper.gameplay;

import me.minesweeper.Player;

/**
 * The Controller class is the center to create an object and send object to another class.
 * @author Warisara
 */
public class Controller {

    private final Menu menu;
    private final Input input;
    private final Bomb bomb;
    private final Player player;

    /**
     * Create all object
     */
    public Controller() {
        menu = new Menu();
        input = new Input();
        bomb = new Bomb();
        player = new Player();
    }

    /**
     * Get Menu object for print output.
     * @return Menu object.
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * Get Input object for let user input data.
     * @return Input object.
     */
    public Input getInput() {
        return input;
    }

    /**
     * Get Bomb object for use information of bombs.
     * @return Bomb object.
     */
    public Bomb getBomb() {
        return bomb;
    }

    /**
     * Get Player object for use information of players.
     * @return Player object.
     */
    public Player getPlayer() {
        return player;
    }
}
