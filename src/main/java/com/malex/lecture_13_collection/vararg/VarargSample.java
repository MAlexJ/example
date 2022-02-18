package com.malex.lecture_13_collection.vararg;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

@Log4j
public class VarargSample {

    @Test
    public void simpleVarargTest() {
        int[] result = useVararg();
        assertTrue(Arrays.equals(new int[0], result));

        result = useVararg(1);
        assertTrue(Arrays.equals(new int[]{1}, result));

        result = useVararg(2, 3, 4, 5);
        assertTrue(Arrays.equals(new int[]{2, 3, 4, 5}, result));

        result = useVararg(5, 3, 2);
        assertTrue(Arrays.equals(new int[]{5, 3, 2}, result));
    }

    public int[] useVararg(int... args) {
        log.debug(Arrays.toString(args));
        return args;
    }
}
