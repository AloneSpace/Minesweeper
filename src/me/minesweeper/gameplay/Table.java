package me.minesweeper.gameplay;

import me.minesweeper.Player;

/**
 * This Table class use for store table data.
 * @author Noppasorn
 */
public class Table {

    private final String[] nowPosition = new String[25];
    private static int count;

    /**
     * Initial default position.
     */
    public Table() {
        for(int i = 0; i < 25; i++) {
            nowPosition[i] = "P" + (i+1);
        }
    }

    /**
     * This method for print table.
     * @param bomb For show how many of safe position.
     */
    public void printTable(Bomb bomb) {
        System.out.print("\n-------------------------------------------------------------\n");
        for(int i = 0; i < 25; i++) {
            if(i % 5 == 0 && i != 0) System.out.print("|\n-------------------------------------------------------------\n");
            if((i+1) >= 10 && !nowPosition[i].equals("\uD83D\uDE06")) System.out.print("|    " + nowPosition[i] + "    ");
            else System.out.print("|    " + nowPosition[i] + "     ");
        }
        System.out.print("|\n-------------------------------------------------------------\n\n");
        System.out.println("Safe position remaining => " + (bomb.getSizeofSafePosition() - count));
    }

    /**
     * This method for print the table and specific position information.
     * @param bomb Use for check if is bomb drop position or not.
     * @param position Use for check if is bomb drop position or not.
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
     * This method for select position and save to data.
     * @param bomb Bomb object use for check if position input same as bomb position.
     * @param player Player object use for increase pickup or increase bomb pickup.
     * @param position Position to check.
     */
    public void selectPosition(Bomb bomb, Player player, int position) {
        boolean isBombDropPosition = bomb.isBombDropPosition(position);
        player.increasePickup();
        if (isBombDropPosition) {
            player.increaseBombPickup();
            count = 0;
        } else {
            nowPosition[position-1] = "\uD83D\uDE06";
            count++;
        }
    }

    /**
     * This method use for check is count equal to size of safe position or not.
     * @param bomb Bomb object for check bomb information.
     * @return true if count equal to size of safe position, false if count not equal to size of safe position.
     */
    public boolean isEndSelected(Bomb bomb) {
        if(count == bomb.getSizeofSafePosition()) {
            count = 0;
            return true;
        }
        return false;
    }

    /**
     * This method use for check if position same as previous position.
     * @param position Position to check.
     * @return true if position same as previous position, false if position not same as previous position.
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
