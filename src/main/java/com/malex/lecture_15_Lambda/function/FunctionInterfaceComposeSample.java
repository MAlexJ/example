package com.malex.lecture_15_Lambda.function;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.util.function.Function;

import static junit.framework.TestCase.assertEquals;

@Log4j
public class FunctionInterfaceComposeSample {

    @Test
    public void testCompose() {
        String compose = oneFunction()      // "1"
                .andThen(twoFunction())     // "2"
                .compose(threeFunction())   // "3"
                .compose(fourFunction())    // "4"
                .apply("0");             // "0"

        assertEquals("04312", compose);
    }

    @Test
    public void testAndThen() {
        String compose = oneFunction()      // "1"
                .andThen(twoFunction())     // "2"
                .andThen(threeFunction())   // "3"
                .andThen(fourFunction())    // "4"
                .apply("0");             // "0"

        assertEquals("01234", compose);
    }

    private Function<String, String> oneFunction() {
        return s -> s + "1";
    }

    private Function<String, String> twoFunction() {
        return s -> s + "2";
    }

    private Function<String, String> threeFunction() {
        return s -> s + "3";
    }

    private Function<String, String> fourFunction() {
        return s -> s + "4";
    }
}