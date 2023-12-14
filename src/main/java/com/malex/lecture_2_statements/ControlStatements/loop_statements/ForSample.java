package com.malex.lecture_2_statements.ControlStatements.loop_statements;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ForSample extends AbstractUtils {

    public ForSample() {
        println("Constructor: base class LoopForSample");
    }

    @Test
    public void runSimpleImpl() {
        boolean condition = true;
        int num = 0;
        println("Before state: num =", num, ", condition =", condition);
        for (; condition; ) {
            print("num :", num + ", ");
            if (num >= 10) {
                condition = false;
            }
            println();
            num++;
        }
        assertEquals(11, num);
        println("After state: num =", num, ", condition =", condition);
    }

    @Test
    public void runImpl() {
        int count = 0;
        println("Before state: count =", count);
        for (int a = 1, b = 4; a < b; a++, b--) {
            println("iteration: a =", a, ", b =", b);
            count++;
        }
        assertEquals(2, count);
        println("After state, count =", count);
    }
}