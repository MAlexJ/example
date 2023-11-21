package com.malex.lecture_15_concurrency.example_19_3_3_forkjoinpool;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static junit.framework.TestCase.assertEquals;

public class ForkJoinPoolOneThreadSample {

    @Test
    public void simpleTest() {
        int[] array = generateRandomNumber(10);
        int maxValue = findMaxValue(0, array.length, array);
        System.out.println(maxValue);
        assertEquals(maxValue, Arrays.stream(array).max().orElseThrow());
    }

    private int findMaxValue(int left, int right, int[] array) {
        if (array.length <= 2 || right - left == 1) {
            return Math.max(array[0], array[1]);
        }
        int mid = (right - left) / 2;
        if (mid == 0) {
            return array[left];
        }
        return Math.max(findMaxValue(left, mid, array), findMaxValue(mid, right, array));
    }

    private int[] generateRandomNumber(int size) {
        Random random = new Random();
        int[] array = IntStream.range(0, size).map(i -> random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE)).toArray();
        System.out.println("length: " + array.length);
        return array;
    }
}
