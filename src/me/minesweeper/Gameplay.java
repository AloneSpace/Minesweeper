package me.minesweeper;

public class Gameplay {

    private int[] bombDrop;
    private int tableSize;
    
    public void printGameMenu() {
        System.out.println("========== [ MineSweeper ] ==========");
    }

    public void startGame() {

    }

    /**
     * @param position เพื่อเช็คตำแหน่งของระเบิด
     * @return true = ถ้าตำแหน่งที่รับมาตรงกับตำแหน่งระเบิด, false = ถ้าตำแหน่งที่รับมาไม่ตรงกับตำแหน่งระเบิด
     */
    public boolean isBombDropPosition(int position) {
        for (int j : bombDrop) {
            if (j == position) return true;
        }
        return false;
    }

    public void printTable() {

    }


    /**
     * สุ่มตำแหน่งระเบิด และเก็บลงใน Array
     */
    public void randBombDropPosition() {
        for (int i = 0; i < tableSize; i++) {
            double randomBombDrop = Math.ceil(Math.random() * 5);
            bombDrop[i] = (int) randomBombDrop;
        }
    }

}
