package com.malex.lecture_4_array.example_10_inverter_array;

import lombok.extern.java.Log;

import java.util.Arrays;


/**
 * Created by admin on 29.01.2015.
 */
@Log
public class ArrayInverter {

    public static void main(String[] args) {
        log.info("main");
        int[] array = {2, 1, 34, 21, 6, 7, 9};
        int[] array2 = {0, 1, 314, 21, 63, 7, 91};
        log.info("array -> " + Arrays.toString(array));
        log.info("array2 -> " + Arrays.toString(array2));

        //  nextTwo(int[] arr)
        nextTwo(array2);

        // OUT-Place algorithm
        int[] arrayOut = invertOut(array);
        log.info("OUT-Place algorithm -> " + Arrays.toString(arrayOut));

        //In-place algorithm
        invertIn(array);
        log.info("In-place algorithm -> " + Arrays.toString(array));
    }

    private static void nextTwo(int[] arr) {
        log.info("nextTwo(int[] arr) -> ");
        for (int i = 0; i < arr.length; i = i + 2) {
            log.info(arr[i] + " ");
        }
        log.info("");
    }

    // In-place algorithm
    private static void invertIn(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
    }

    // Out-place algorithm
    private static int[] invertOut(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[result.length - 1 - i] = arr[i];
        }
        return result;
    }
}
