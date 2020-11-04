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
    public void selectPosition(Bomb bomb, int position) {
        boolean isBombDropPosition = bomb.isBombDropPosition(position);
        if(!isBombDropPosition) {
            nowPosition[position-1] = "S";
        }
    }
}
