package com.malex.lecture_2_statements.ControlStatements.flow_control_statements;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BreakEscapeFromTwoLoops extends AbstractUtils {

    @Test
    public void runTest() {
        wrapper("Break inside two loops", () -> {
            int i = 0;
            int j = 0;
            for (; i < 5; i++) {
                for (; j < 5; j++) {
                    if (j >= 3) {
                        print("break", "j=", j, "; ");
                        break;
                    }
                }
                println("i=", i);
            }
            print("After loop, i++", "i=", i);
            assertEquals(5, i);
            assertEquals(3, j);
        });
    }
}
