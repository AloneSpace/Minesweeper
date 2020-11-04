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

    /**
     * @param qty ส่งค่าจำนวนระเบิดว่าต้องการเท่าไหร่
     */
    public void setQTYBomb(int qty) {
        this.qty = qty;
    }

    /**
     * @param position หาตำแหน่งระเบิดทั้งแกน X,Y และแนวเฉียงว่า ระเบิดอยู่แถวไหน
     * @return ส่งค่าเมื่อผู้เล่นเลือกตำแหน่งนี้จะมีระเบิดอยู่ห่างจากบล็อคที่ผู้เล่นเลือกกี่บล็อค
     */
    public int findNearByBomb(int position) {
        int nearBlock;
        nearBlock = 1;
        return nearBlock;
    }
}
