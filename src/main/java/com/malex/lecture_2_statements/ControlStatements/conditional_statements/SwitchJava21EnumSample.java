package com.malex.lecture_2_statements.ControlStatements.conditional_statements;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Link to info: <a href="https://habr.com/ru/articles/443464/">Complete manual switch in Java</a>
 */
public class SwitchJava21EnumSample extends AbstractUtils {

    @Test
    public void test() {
        String expression = switchExpression(SYMBOL.A);
        assertEquals("a", expression);

        expression = switchExpression(SYMBOL.B);
        assertEquals("b", expression);

        expression = switchExpression(SYMBOL.NONE);
        assertEquals("default", expression);
    }

    enum SYMBOL {
        A, B, C, D, NONE
    }

    private String switchExpression(SYMBOL symbol) {
        String result = switch (symbol) {
            case A -> "a";
            case B -> "b";
            case D -> "d";
            default -> "default";
        };
        print(result);
        return result;
    }

}