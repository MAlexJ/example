package com.malex.lecture_4_array.example_06_exchange_variable;

import lombok.extern.java.Log;

import java.util.Arrays;

@Log
public class SwapArray {

    private static final int[] ARRAY = new int[2];

    public static void main(String[] args) {
        ARRAY[0] = 34;
        ARRAY[1] = 56;
        log.info("before - " + Arrays.toString(ARRAY));

        swap(ARRAY);
        log.info("after - " + Arrays.toString(ARRAY));
    }

    private static void swap(int[] array) {
        int result = array[0];
        array[0] = array[1];
        array[1] = result;
    }
}
