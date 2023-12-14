package com.malex.lecture_2_statements.ControlStatements.conditional_statements;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class If_Java16_TypePatternMatchingWithInstanceof extends AbstractUtils {

    @Test
    public void runSimpleExample() {
        assertEquals(6, defineObject("Hello!"));
        assertEquals(4, defineObject(2));
        assertEquals(6, defineObject(60d));
    }

    private int defineObject(Object obj) {
        println("init state, obj =", obj);
        if (obj instanceof String s) {
            return s.length();
        }
        if (obj instanceof Integer i) {
            return i + i;
        }
        if (obj instanceof Double d) {
            return (int) (d / 10);
        }
        throw new UnsupportedOperationException();
    }
}
