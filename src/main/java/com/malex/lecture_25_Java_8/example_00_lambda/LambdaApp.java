package com.malex.lecture_25_Java_8.example_00_lambda;

import java.util.Comparator;
import java.util.stream.Stream;

import org.junit.Test;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Log4j
@ToString
public class LambdaApp {

    @Setter
    @Getter
    private String field = "field";

    private static LambdaApp create(Functional<LambdaApp> functional, String name) {
        LambdaApp lambda = functional.get();
        if (name != null) {
            lambda.setField(name);
        }
        return lambda;
    }


    @Test
    public void testStreamPeekMethod() {
        String separator = "\n";
        Stream.of("a", "b")
                .peek(e -> log.debug("Intermediate operation: " + separator))
                .forEach(log::debug);
    }

    @Test
    public void testStreamSortedMethod() {
        Stream.of("w", "c", "a", "b")
                .sorted()
                .forEach(log::debug);
    }

    @Test
    public void testCustomFunctionalInterface() {
        LambdaApp l1 = LambdaApp.create(LambdaApp::new, "new name");
        LambdaApp l2 = LambdaApp.create(LambdaApp::new, "old name");
        LambdaApp l3 = LambdaApp.create(LambdaApp::new, null);

        Stream.of(l1, l2, l3)
                .sorted(Comparator.comparing(LambdaApp::getField))
                .forEach(log::debug);
    }

}

/**
 * This it functional interface
 *
 * @param <T> - generic
 */
@FunctionalInterface
interface Functional<T> {

    T get();
}