package com.malex.lecture_4_array.example_01_array_one;

import lombok.extern.java.Log;

import java.util.Arrays;

@Log
public class InitArrayMain {

    public static void main(String[] args) {
        simpleInit();
        fastInit();
        whileLoop();
        recursive();
    }

    private static void simpleInit() {
        int[] numArray = new int[5];
        numArray[0] = 1;
        numArray[1] = 2;
        numArray[2] = 3;
        numArray[3] = 4;
        numArray[4] = 5;

        // Array
        int numLength = numArray.length;

        log.info("numArray.length -> " + numLength);
        log.info(Arrays.toString(numArray));
    }

    private static void fastInit() {
        int[] number = {2, 5, 7, 6};
        for (int i = 0; i < number.length; i++) {
            log.info("arr[i]=" + number[i]);
        }
    }

    private static void whileLoop() {
        int[] number = {2, 5, 7, 6};
        int position = 0;
        while (position < number.length) {
            log.info("position=" + number[position]);
            position++;
        }
    }

    private static void recursive() {
        int[] number = {2, 5, 7, 6};
        recursiveIteration(number, 0);
    }

    private static void recursiveIteration(int[] array, int i) {
        log.info("elem = " + array[i]);
        i++;
        if (i < array.length) {
            recursiveIteration(array, i);
        }
    }

}
