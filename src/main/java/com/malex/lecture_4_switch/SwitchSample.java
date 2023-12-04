package com.malex.lecture_4_switch;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

/**
 * Link to info: https://habr.com/ru/articles/443464/
 */
public class SwitchSample {

    enum SYMBOL {
        A, B, C, D, NONE
    }

    @Test
    public void test() {
        String expression = switchExpression(SYMBOL.A);
        print(expression);
        assertEquals("a", expression);
    }


    private String switchExpression(SYMBOL symbol) {
        return switch (symbol) {
            case A -> "a";
            case B -> "b";
            case D -> "d";
            default -> "default";
        };
    }

    private void print(Object... args) {
        String logs = Arrays.stream(args).map(Object::toString).collect(Collectors.joining(" "));
        System.out.println(logs);
    }
}
