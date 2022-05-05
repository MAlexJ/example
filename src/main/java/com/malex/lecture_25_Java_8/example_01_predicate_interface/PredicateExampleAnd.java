package com.malex.lecture_25_Java_8.example_01_predicate_interface;

import lombok.extern.java.Log;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Predicate and returns a composed predicate that represents a short-circuiting
 * logical AND of this predicate and another.
 */
@Log
public class PredicateExampleAnd {
    public static void main(String[] args) {
        Predicate<String> isContainsJ = str -> str.contains("j") || str.contains("J");
        Predicate<String> isContainsA = str -> str.contains("a") || str.contains("A");

        String collect = Stream.of("Java", "JS", "JavaScript", "Query", "Oracle")
                .filter(isContainsA.and(isContainsJ))
                .collect(Collectors.joining(","));
        log.info("Example: AND -> " + collect);
    }
}
