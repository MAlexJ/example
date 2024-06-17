package com.malex.lecture_3_mutable_vs_immutable.immutable;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

/**
 * All primitive wrapper classes (Integer, Byte, Long, Float, Double, Character, Boolean and Short)
 * are immutable in Java, so operations like addition
 * and subtraction create a new object and not modify the old.
 */
public class PrimitiveWrapperImmutable extends AbstractUtils {

    @Test
    public void testInteger() {
        // given
        Integer result = Integer.valueOf(5);
        // and
        String initHashcode = getHashcode(result);
        print("before =", result, ", hash =", initHashcode);

        // when
        result = result + 1;
        print("after =", result, ", hash =", getHashcode(result));

        // then
        assertNotEquals(initHashcode, getHashcode(result));
    }

    @Test
    public void testByte() {
        Byte aByte = Byte.valueOf((byte) 112);
        String initHashcode = getHashcode(aByte);
        print("before =", aByte, ", hash =", initHashcode);
        aByte = 67;
        print("after =", aByte, ", hash =", getHashcode(aByte));
        assertNotEquals(initHashcode, getHashcode(aByte));
    }

}