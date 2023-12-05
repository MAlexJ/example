package com.malex.lecture_2_statements.ControlStatements.flow_control_statements;

import com.malex.lecture_2_statements.AbstractStatements;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static junit.framework.TestCase.assertEquals;

public class ReturnStatement extends AbstractStatements {

    @Test
    public void runTest() {
        // info: Variable used in lambda expression should be final or effectively final
        AtomicInteger num = new AtomicInteger(0);

        wrapper("Return statement inside code", () -> {
            boolean flag = true;
            num.getAndIncrement();
            println(num.get());
            if (flag) return;
            num.getAndIncrement();
            println(num.get());
        });
        assertEquals(1, num.get());
    }
}
