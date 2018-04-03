package com.malex.lecture_2_continium_break_return;

public class Break_exit_cycle {

    public static void main(String[] args) {

        System.out.println("Example 1: for");

        for (int i = 0; i < 5; i++) {
            if (i >= 3) {
                break;
            }
            System.out.println("i=" + i);
        }
        System.out.println();

        System.out.println("Example 2: while");
        int j = 0;
        while (true) {
            System.out.println("j=" + j);
            if (j >= 5) {
                break;
            }
            j++;
        }
    }
}
