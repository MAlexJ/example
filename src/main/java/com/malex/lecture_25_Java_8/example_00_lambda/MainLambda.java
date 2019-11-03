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
public class MainLambda {

    @Setter
    @Getter
    private String field = "field";

    private static MainLambda create(Functional<MainLambda> functional, String name) {
        MainLambda lambda = functional.get();
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
        MainLambda l1 = MainLambda.create(MainLambda::new, "new name");
        MainLambda l2 = MainLambda.create(MainLambda::new, "old name");
        MainLambda l3 = MainLambda.create(MainLambda::new, null);

        Stream.of(l1, l2, l3)
                .sorted(Comparator.comparing(MainLambda::getField))
                .forEach(System.out::println);
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