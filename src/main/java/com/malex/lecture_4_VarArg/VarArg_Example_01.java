package com.malex.lecture_4_VarArg;

public class VarArg_Example_01 {

    public static void main(String[] args) {
        // example 1
        varArg(1);
        varArg();
        varArg(1, 2, 3, 7);

        // example 2
        varArg_1(1);
        varArg_1(1, 1, 2, 6, 9);
    }

    private static void varArg(int... varArg) {
        for (int item : varArg) System.out.print(item);
        System.out.println();
    }

    private static void varArg_1(int first, int... varArg) {
        System.out.print(first);
        for (int item : varArg) {
            System.out.print(item);
        }
        System.out.println();
    }

    //    static void varArg_2(int ... var, int i){} //Error
    //    static void varArg_2(int ... var, int ... i){} //Error
    static void varArg_2(int q, int f, int... i) {
    }
}
