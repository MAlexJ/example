package com.malex.lecture_2_statements.ControlStatements.flow_control_statements;

import com.malex.lecture_2_statements.AbstractStatements;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BreakWithLabelAsGoto extends AbstractStatements {

    @Test
    public void runTest() {
        boolean flag = true;
        int num = 0;
        first:
        {
            num = num + 1;
            println(">>> In first section", ", num =", num);
            second:
            {
                num = num + 2;
                println(" >>> In second section", ", num =", num);
                third:
                {
                    num = num + 3;
                    println("   >>> In third section", ", num =", num);
                    if (flag) break second;
                    num = num - 30;
                    println("  <<< In third section", ", num =", num);
                }
                num = num - 20;
                println(" <<< In second section", ", num =", num);
            }
            num = num - 1;
            println("<<< In first section", ", num =", num);
        }
        assertEquals(5, num);
    }

}