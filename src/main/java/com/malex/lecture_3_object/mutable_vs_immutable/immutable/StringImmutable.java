package com.malex.lecture_3_object.mutable_vs_immutable.immutable;


import com.malex.utils.AbstractUtils;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

/**
 * In Java, all the wrapper classes like Boolean, Short, Integer, Long, Float, Double, Byte, Char,
 * and String classes are immutable classes.
 */
public class StringImmutable extends AbstractUtils {

    @Test
    public void test() {
        String s1 = "int string";
        int hashCode = s1.hashCode();
        println("hashCode:", hashCode, "value:", s1);

        s1 = s1.replace('i', 'x');
        int newHashCode = s1.hashCode();
        println("hashCode after replace:", newHashCode, "value:", s1);
        assertNotEquals(hashCode, newHashCode);
    }
}
