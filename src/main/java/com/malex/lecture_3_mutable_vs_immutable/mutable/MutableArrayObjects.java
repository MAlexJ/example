package com.malex.lecture_3_mutable_vs_immutable.mutable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MutableArrayObjects {

    @Test
    public void test() {
        int[] array = {1, 2, 3, 4, 5};
        var mutableArray = new MutableArray(array);
        assertArrayEquals(mutableArray.getArray(), new int[]{1, 2, 3, 4, 5});

        array[0] = -9;
        array[1] = -8;
        assertArrayEquals(mutableArray.getArray(), new int[]{-9, -8, 3, 4, 5});
    }


    @Getter
    @RequiredArgsConstructor
    static class MutableArray {
        private final int[] array;
    }
}
