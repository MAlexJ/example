package com.malex.lecture_2_statements.ControlStatements.flow_control_statements;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BreakInsideLoop extends AbstractUtils {

    @Test
    public void runExample() {
        // for statement test
        wrapper("First example, exit from for loop", () -> {
            int num = 1;
            for (int i = 0; i < 6; i++) {
                if (i >= 3) {
                    break;
                }
                num++;
            }
            assertEquals(4, num);
        });

        // while statement test
        wrapper("Second example, escape from while loop", () -> {
            int j = 0;
            while (true) {
                System.out.println("j=" + j);
                if (j >= 5) {
                    break;
                }
                j++;
            }
            assertEquals(5, j);
        });
    }
}
