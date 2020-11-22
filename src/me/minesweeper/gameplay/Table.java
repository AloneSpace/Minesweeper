package me.minesweeper.gameplay;

import me.minesweeper.Player;

/**
 * Class Table ทำหน้าที่ Print ตาราง ในแต่ละตารางมีระเบิดหรือไม่ เป็นต้น
 */
public class Table {

    private final String[] nowPosition = new String[25];
    private static int count;

    public Table() {
        for(int i = 0; i < 25; i++) {
            nowPosition[i] = "P" + (i+1);
        }
    }

    /**
     * สำหรับ Print ตาราง
     */
    public void printTable() {
        System.out.print("\n-------------------------------------------------------------\n");
        for(int i = 0; i < 25; i++) {
            if(i % 5 == 0 && i != 0) System.out.print("|\n-------------------------------------------------------------\n");
            if((i+1) >= 10) System.out.print("|    " + nowPosition[i] + "    ");
            else System.out.print("|    " + nowPosition[i] + "     ");
        }
        System.out.print("|\n-------------------------------------------------------------\n\n");
    }

    /**
     * สำหรับ Print ตารางทั้งหมดว่าในแต่ละตำแหน่งมีอะไรบ้าง
     */
    public void printSummaryTable(Bomb bomb, int position) {
        System.out.print("\n--------------------------------------------------------\n");
        for(int i = 0; i < 25; i++) {
            if(bomb.isBombDropPosition(i+1)) { // ถ้าตำแหน่งที่เลือกเจอระเบิด
                if((i+1) == position) { //ถ้าตำแหน่งนี้ เป็นตำแหน่งที่เราเลือก
                    nowPosition[i] = "\uD83D\uDCA5"; //เปลี่ยนเป็นไอคอนระเบิด
                } else {
                    nowPosition[i] = "\uD83E\uDDE8"; //เปลี่ยนเป็นไอคอนประทัด
                }
            } else {
                if(!nowPosition[i].equals("\uD83D\uDE06")) { //ถ้าตำแหน่งนี้ เป็นตำแหน่งเป็นรูปยิ้ม
                    nowPosition[i] = "\uD83D\uDC9A"; //เปลี่ยนเป็นไอคอนหัวใจสีเขียว
                } else {
                    nowPosition[i] = "\uD83D\uDE06"; //เปลี่ยนเป็นไอคอนรูปหัวเราะ
                }
            }
            if(i % 5 == 0 && i != 0) System.out.print("|\n--------------------------------------------------------\n");
            System.out.print("|    " + nowPosition[i] + "    ");
        }
        System.out.print("|\n--------------------------------------------------------\n\n");
        System.out.println("\uD83D\uDCA5 = The place where a bomb had exploded");
        System.out.println("\uD83E\uDDE8 = The place where a bomb had planted");
        System.out.println("\uD83D\uDE06 = The place where player picked");
        System.out.println("\uD83D\uDC9A = The place where safe position");
    }

    /**
     * @param bomb รับ Object Bomb
     * @param position รับ position: int เพื่อเช็คดูว่าตำแหน่งนั้นมี
     */
    public void selectPosition(Bomb bomb, Player player, int position) {
        boolean isBombDropPosition = bomb.isBombDropPosition(position);
        player.increasePickup();
        if (isBombDropPosition) {
            player.increaseBombPickup();
        } else {
            nowPosition[position-1] = "\uD83D\uDE06";
            count++;
        }
    }

    /**
     * @param bomb รับ Object Bomb เพื่อเช็คว่า จำนวนพื้นที่ที่ปลอดภัยเท่ากับจำนวนรอบที่เลือกหรือไม่
     * @return true ถ้าจำนวนพื้นที่ปลอดภัย == จำนวนรอบที่เลือก,  false ถ้า จำนวนพื้นที่ปลอดภัย != จำนวนรอบที่เลือก
     */
    public boolean isEndSelected(Bomb bomb) {
        return count == bomb.getSizeofSafePosition();
    }

    /**
     * @param position รับ position: int() เพื่อเช็คตำแหน่งว่าซ้ำกันหรือไม่
     * @return true ถ้าตำแหน่งที่ Input ซ้ำกัน, false ถ้าตำแหน่งที่ Input ไม่ซ้ำกัน
     */
    public boolean isSamePosition(int position) {
        for(int i = 0; i < nowPosition.length; i++) {
            if(nowPosition[i].equals("\uD83D\uDE06")) {
                if((i+1) == position) return true;
            }
        }
        return false;
    }
}
