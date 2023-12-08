package com.malex.lecture_2_statements.ControlStatements.conditional_statements;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.UncheckedIOException;
import java.util.Arrays;

import static com.malex.lecture_2_statements.ControlStatements.conditional_statements.SwitchJava13YieldSample.NewBoolean.getByName;
import static junit.framework.TestCase.*;

/**
 * Link to info: <a href="https://habr.com/ru/articles/443464/">complete manual switch in Java</a>
 */
public class SwitchJava13YieldSample {
    @Test
    public void test() {
        // given
        NewBoolean newBoolean = getByName("true");
        // when
        boolean result = switchExpression(newBoolean);
        //then
        assertTrue(result);

        //then
        assertFalse(switchExpression(getByName("False")));

        //then
        try {
            assertFalse(switchExpression(getByName("None")));
            fail();
        } catch (UncheckedIOException e) {
            // success result
        }
    }

    private static boolean switchExpression(NewBoolean newBoolean) {
        return switch (newBoolean) {
            case TRUE:
                yield true;
            case FALSE:
                yield false;
            case FILE_NOT_FOUND:
                throw new UncheckedIOException(
                        "This is ridiculous!",
                        new FileNotFoundException());
            default:
                throw new IllegalArgumentException("Seriously?!");
        };
    }


    enum NewBoolean {
        TRUE, FALSE, FILE_NOT_FOUND;

        public static NewBoolean getByName(String name) {
            return Arrays.stream(values()) //
                    .filter(val -> val.name().equalsIgnoreCase(name)) //
                    .findFirst() //
                    .orElse(NewBoolean.FILE_NOT_FOUND);
        }
    }
}
