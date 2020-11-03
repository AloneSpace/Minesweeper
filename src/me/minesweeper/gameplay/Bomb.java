package me.minesweeper.gameplay;

public class Bomb {

    private int qty;
    private int[] bombDrop;

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

    /**
     * สุ่มตำแหน่งระเบิด และเก็บลงใน Array
     */
    public void randBombDropPosition() {
        for (int i = 0; i < qty; i++) {
            double randomBombDrop = Math.ceil(Math.random() * qty);
            bombDrop[i] = (int) randomBombDrop;
        }
    }

    public void setQTYBomb(int qty) {
        this.qty = qty;
    }
}
