package com.malex.lecture_15_Lambda.function;

import lombok.extern.java.Log;
import org.junit.Test;

import java.util.function.Function;

import static junit.framework.TestCase.assertEquals;

@Log
public class FunctionInterfaceComposeAndThenSample {

    @Test
    public void simpleTest() {
        // given
        int number = 4;
        Function<String, Integer> fn1 = Integer::parseInt;
        Function<Integer, Integer> fn2 = num -> num * num;
        Function<Integer, String> fn3 = num -> num + "_java";

        // when
        String result = fn1.andThen(fn2) //
                .andThen(fn3) //
                .apply(Integer.toString(number));

        // then
        assertEquals("16_java", result);
    }

    @Test
    public void testComposeSequence() {
        String compose = oneFunction()      // "1"
                .compose(twoFunction())     // "2"
                .compose(threeFunction())   // "3"
                .compose(fourFunction())    // "4"
                .apply("0");             // "0"

        assertEquals("04321", compose);
    }

    @Test
    public void testAndThenSequence() {
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