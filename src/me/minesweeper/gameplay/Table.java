package me.minesweeper.gameplay;

public class Table {

    private final String[] nowPosition = new String[25];
    private static int count;

    public Table() {
        for(int i = 0; i < 25; i++) {
           nowPosition[i] = "P";
        }
    }

    /**
     * สำหรับ Print ตาราง
     */
    public void printTable() {
        System.out.print("\n-----------------------------------------\n");
        for(int i = 0; i < 25; i++) {
            if(i % 5 == 0 && i != 0) System.out.print("|\n-----------------------------------------\n");
            System.out.print("|\t" + nowPosition[i] + "\t");
        }
        System.out.print("|\n-----------------------------------------\n\n");
    }

    /**
     * @param bomb รับ Object Bomb
     * @param position รับ position: int เพื่อเช็คดูว่าตำแหน่งนั้นมี
     */
    public void selectPosition(Menu menu, Bomb bomb, int position) {
        boolean isBombDropPosition = bomb.isBombDropPosition(position);
        if(!isBombDropPosition) {
            nowPosition[position-1] = "S";
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
            if(nowPosition[i].equals("S")) {
                if((i+1) == position) return true;
            }
        }
        return false;
    }
}
