package com.malex.lecture_25_Java_8.example_01_predicate_interface;

import lombok.extern.java.Log;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Predicate isEqual returns a predicate that tests if two arguments are equal according to Objects.equals(Object, Object).
 */
@Log
public class PredicateExampleIsEquals {
    private static final String DEFAULT_VALUE = "java";

    public static void main(String[] args) {
        Predicate<String> predicateString = Predicate.isEqual(DEFAULT_VALUE);

        String name = "java";
        log.info("Example #1: " + predicateString.test(name));
        
        name = "Alex";
        log.info("Example #1: " + predicateString.test(name) + "\n");

        String result = Stream.of("java", "JS", "Angular", "ReactJS")
                .filter(predicateString)
                .collect(Collectors.joining(","));
        log.info("Example #2: " + result);
    }
}
