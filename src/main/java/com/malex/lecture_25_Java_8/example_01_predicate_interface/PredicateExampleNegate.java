package com.malex.lecture_25_Java_8.example_01_predicate_interface;

import lombok.extern.java.Log;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Predicate negate returns a predicate that represents the logical negation of this predicate.
 */
@Log
public class PredicateExampleNegate {
    public static void main(String[] args) {
        Predicate<Integer> predicate = num -> num > 5;
        log.info("Example #1: predicate.negate() -> " + predicate.negate().test(10) + "\n");
        log.info("Example #1: predicate.negate() -> " + predicate.negate().test(1) + "\n");

        List<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .collect(Collectors.toList());

        List<Integer> result = integerStream
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
        log.info("Example #2: predicate -> " + result);

        List<Integer> resultNegate = integerStream
                .stream()
                .filter(predicate.negate())
                .collect(Collectors.toList());
        log.info("Example #2: predicate.negate() -> " + resultNegate);
    }
}
