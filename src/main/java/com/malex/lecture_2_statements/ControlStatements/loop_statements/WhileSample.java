package com.malex.lecture_2_statements.ControlStatements.loop_statements;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class WhileSample extends AbstractUtils {

    public WhileSample() {
        println("Constructor: base class WhileSample");
    }

    @Test
    public void run() {
        boolean condition = true;
        println("Before init state:", condition);
        int i = 0;
        while (condition) {
            if (i > 5) {
                condition = false;
            }
            i++;
        }
        assertEquals(7, i);
        println("After init state:", condition);
    }

}
