package com.malex.lecture_4_algorithms;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ReverseNumber {

    /**
     * Given a 32-bit signed integer, reverse digits of an integer.
     */
    private static int reverseNumber(int num) {
        long result = 0;
        while (num != 0) {
            result = result * 10;
            result = result + num % 10;
            num = num / 10;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) result;
    }

    @Test
    public void test() {
        assertEquals(0, reverseNumber(0));
        assertEquals(0, reverseNumber(-0));
        assertEquals(-654321, reverseNumber(-123456));
        assertEquals(0, reverseNumber(1534236469));
    }
}
