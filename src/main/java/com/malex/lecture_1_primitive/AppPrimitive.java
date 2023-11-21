package com.malex.lecture_1_primitive;

import java.util.Arrays;

/**
 * In case of abbreviated operations in java, type casting is performed.
 * That is, v1 + = v2 is analogous to v1 = (int) (v1 + v2)
 * Accordingly, the first line will have a compilation error since long is wider than int,
 * and the second line will be successfully executed.
 */
public class AppPrimitive {
    public static void main(String[] args) {
        System.out.println("8 / 2=" + 8 / 2);
        System.out.println("9 / 2=" + 9 / 2);
        System.out.println("9 % 2=" + 9 % 2);

    }

    private static int[][] splitArrayInHalf(int[] array) {
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[mid];
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
            right[i] = array[i + mid];
        }
        return new int[][]{left, right};
    }

}