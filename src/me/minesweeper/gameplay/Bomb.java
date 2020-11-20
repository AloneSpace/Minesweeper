package me.minesweeper.gameplay;

import java.util.ArrayList;

/**
 * Class Bomb ทำหน้าที่สุ่มระเบิดและเก็บระเบิดไปไว้ที่ตำแหน่งต่างๆในตาราง
 */
public class Bomb {

    private int qty;
    private ArrayList<Integer> bombDrop;
    private ArrayList<Integer> safePosition;

    /**
     * เช็คตำแหน่งระเบิด
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
        bombDrop = new ArrayList<>();
        safePosition = new ArrayList<>();
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
     * จำนวนตำแหน่งทั้งหมดที่ไม่มีระเบิด
     * @return int: ขนาดของตำแหน่งที่ปลอดภัยจากระเบิด
     */
    public int getSizeofSafePosition() {
        return safePosition.size();
    }

    /**
     * บันทึกจำนวนระเบิดทั้งหมด
     * @param qty ส่งค่าจำนวนระเบิดว่าต้องการเท่าไหร่
     */
    public void setQTYBomb(int qty) {
        this.qty = qty;
    }

}
