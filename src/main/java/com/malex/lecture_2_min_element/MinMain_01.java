package com.malex.lecture_2_min_element;

/**
 * Created by malex on 11.07.16.
 */
public class MinMain_01 {

    public static void main(String[] args) {
        System.out.println("Min number: " + findMinNumber(235, 54, 2, 5858));
    }

    private static long findMinNumber(long num1, long num2, long num3, long num4) {
        return Math.min(num1, Math.min(num2, Math.min(num3, num4)));
    }
}
