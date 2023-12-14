package com.malex.lecture_2_statements.ControlStatements.conditional_statements;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static junit.framework.TestCase.assertEquals;

public class SwitchExpressionBaseSample extends AbstractUtils {

    @Test
    public void runVoidSample() {
        LongStream.of(1, 3L, 10).forEach(num -> {
            switch (Long.toString(num)) {
                case "1" -> println("1. first");
                case "3" -> println("3. third");
                case "10" -> println("10. tenth");
                default -> println("default");
            }
        });
    }

    @Test
    public void testIntegerInAndStringOut() {
        // test 1
        IntStream.range(1, 4).forEach(num -> assertEquals("first", switchExpression(num)));

        // test 2
        IntStream.range(5, 8).forEach(num -> assertEquals("second", switchExpression(num)));

        // test 3
        IntStream.of(9, 11, 12, 14, 16).forEach(num -> assertEquals("default", switchExpression(num)));
    }

    private String switchExpression(int number) {
        return switch (number) {
            case 1, 2, 3, 4 -> "first";
            case 5, 6, 7, 8 -> "second";
            default -> "default";
        };
    }
}