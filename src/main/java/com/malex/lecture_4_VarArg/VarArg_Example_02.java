package com.malex.lecture_4_VarArg;

import java.util.Arrays;

public class VarArg_Example_02 {

    public static void main(String[] args) {
        varArg(1, 3, 4);
        varArg(true);
//        varArg(); //Error `
    }

    private static void varArg(int... var) {
        System.out.println(Arrays.toString(var));
    }

    private static void varArg(boolean... var) {
        System.out.println(Arrays.toString(var));
    }
}
