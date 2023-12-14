package com.malex.lecture_2_statements.ControlStatements.flow_control_statements;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ContinueWithLabel extends AbstractUtils {

    @Test
    public void runLess() {
        th:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > i) {
                    println("+");
                    continue th;
                }
                print(j);
            }
        }
    }

    @Test
    public void run() {
        wrapper("Inner loop label", () -> {
            // init parameters
            int num = 0;
            int max = 10;
            int inner_max = 5;
            println("init params", "num =", num, "max =", max, "inner max =", inner_max);

            // impl
            back_label:
            for (int i = 0; i < max; i++) {
                for (int j = 0; j < inner_max; j++) {
                    if (j < i) {
                        println("+");
                        continue back_label;
                    }
                    num++;
                    print(j);
                }
            }
            println("result =", num);
            assertEquals(inner_max, num);
        });
    }
}