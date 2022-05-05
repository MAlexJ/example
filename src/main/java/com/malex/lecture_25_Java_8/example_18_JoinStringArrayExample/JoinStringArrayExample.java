package com.malex.lecture_25_Java_8.example_18_JoinStringArrayExample;

import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Title: Java 8 – Join String Array Example
 * Link: https://howtodoinjava.com/java-8/java-8-join-string-array-example/
 *
 * @author malex
 * @since Oct 14, 2017
 */
@Log
public class JoinStringArrayExample {

    /**
     * Java examples to join string array to produce single String.
     */
    public static void main(String[] args) {

        // java 8 -> String.join(..)
        stringJoin();

        // Stream -> Collectors.joining(.....)
        collectorsJoining();
    }

    private static void stringJoin() {
        String[] strArray = {"How", "To", "Do", "In", "Java"};

        String joinedString = String.join(", ", strArray);

        log.info(joinedString);
    }

    private static void collectorsJoining() {
        List<String> numbers = Arrays.asList("How", "To", "Do", "In", "Java");

        String joinedString = numbers
                .stream()
                .collect(Collectors.joining(", ", "[", "]"));

        log.info(joinedString);
    }
}