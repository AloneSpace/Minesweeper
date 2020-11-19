package me.minesweeper.gameplay;

import me.minesweeper.Player;

/**
 * ส่วนกลางที่คอยควบส่ง Class ต่างๆ
 */
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

    /**
     * @return Object menu เพื่อนำไปใช้ต่อไป
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * @return Object input เพื่อให้ User สามารถ Input ได้
     */
    public Input getInput() {
        return input;
    }

    /**
     * @return Object bomb ทำหน้าที่สุ่มระเบิด หาตำแหน่งระเบิด เป็นต้น
     */
    public Bomb getBomb() {
        return bomb;
    }

    /**
     * @return
     */
    public Player getPlayer() {
        return player;
    }
}
