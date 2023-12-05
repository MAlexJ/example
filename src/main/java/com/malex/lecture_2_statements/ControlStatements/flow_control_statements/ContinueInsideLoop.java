package com.malex.lecture_2_statements.ControlStatements.flow_control_statements;

import com.malex.lecture_2_statements.AbstractStatements;
import org.junit.Test;

// transition operators.
public class ContinueInsideLoop extends AbstractStatements {

    @Test
    public void runTest(){
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            if (i % 2 == 0) {
                continue;
            }
            System.out.println();
        }

        boolean flag = true;
        int i = 0;
        while (flag) {
            System.out.print(i++);
            if (i % 2 == 0) {
                System.out.print("+");
                continue;
            }
            System.out.println("-");
            if (i >= 20) {
                flag = false;
            }
        }
    }
}
