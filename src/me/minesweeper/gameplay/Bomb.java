package me.minesweeper.gameplay;

import java.util.ArrayList;

public class Bomb {

    private int qty;
    private ArrayList<Integer> bombDrop = new ArrayList<>();
    private ArrayList<Integer> safePosition = new ArrayList<>();

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
     * สุ่มตำแหน่งระเบิด และบันทึกลงใน Array
     */
    public void randBombDropPosition() {
        double checkSame = 0;
        while (bombDrop.size() < qty) {
            double randomBombDrop = Math.ceil(Math.random() * 25);
            if (!bombDrop.contains((int) randomBombDrop)) {
                bombDrop.add((int) randomBombDrop);
            }
        }
        for(int i = 1; i <= 25; i++) {
            if(!bombDrop.contains(i)) {
                safePosition.add(i);
            }
        }
    }

    /**
     * สำหรับค้นหาว่าระเบิดอยู่ในช่องไหน
     * @return Array ว่า Bomb แต่ละลูกอยู่ตำแหน่งใดบ้าง
     */
    public String getBombDrop() {
        return bombDrop.toString();
    }

    /**
     * สำหรับค้นหาว่าตำแหน่งที่ไม่มีระเบิด
     * @return Array ตำแหน่งที่ไม่มีระเบิด
     */
    public String getSafePosition() {
        return safePosition.toString();
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
