package com.malex.lecture_13_collection_api.vararg;

import lombok.extern.java.Log;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;

@Log
public class VarargTestSample {

    @Test
    public void simpleVarargTest() {
        int[] result = useVararg();
        assertArrayEquals(new int[0], result);

        result = useVararg(1);
        assertArrayEquals(new int[]{1}, result);

        result = useVararg(2, 3, 4, 5);
        assertTrue(compareArrays(new int[]{2, 3, 4, 5}, result));

        result = useVararg(5, 3, 2);
        assertTrue(compareArrays(new int[]{5, 3, 2}, result));
    }

    private int[] useVararg(int... args) {
        log.info(Arrays.toString(args));
        return args;
    }

    private boolean compareArrays(int[] arr1, int[] arr2) {
        return Arrays.equals(arr1, arr2);
    }
}
