package com.malex.lecture_4_array.example_10_inverter_array;

import lombok.extern.java.Log;

import java.util.Arrays;

@Log
public class App_00_int_tmp {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6};
        log.info(Arrays.toString(array));

        for (int i = 0; i < array.length - 1; i++) {
            swap(array, i, i + 1);
        }

        log.info(Arrays.toString(array));
    }

    private static void swap(int[] arr, int frs, int scd) {
        if (arr == null) {
            log.severe("arr[] = null");
            return;
        }
        int tmp = arr[frs];
        arr[frs] = arr[scd];
        arr[scd] = tmp;
    }
}
