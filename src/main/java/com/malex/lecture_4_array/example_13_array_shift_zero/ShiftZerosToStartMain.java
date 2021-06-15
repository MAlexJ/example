package com.malex.lecture_4_array.example_13_array_shift_zero;

import lombok.extern.java.Log;

import java.util.Arrays;

@Log
public class ShiftZerosToStartMain {

    public static void main(String[] args) {
        int[] arr = {1, 4, 8, 0, 7, 5, 0, 0, -1, 5, 0, 0, 0, 2};
        log.info("result - " + Arrays.toString(moveZerosToStart(arr)));
        log.info("result - " + Arrays.toString(moveZerosToStart(new int[]{0, 1, 0, 8, 0, 1})));
    }

    private static int[] moveZerosToStart(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must have values!");
        }
        int[] tmpArr = new int[arr.length];
        int position = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int elem = arr[i];
            if (elem != 0) {
                tmpArr[position] = elem;
                position--;
            }
        }
        return tmpArr;
    }
}
