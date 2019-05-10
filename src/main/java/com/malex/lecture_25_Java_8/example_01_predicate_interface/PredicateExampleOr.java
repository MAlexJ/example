package com.malex.lecture_25_Java_8.example_01_predicate_interface;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Predicate or returns a composed predicate that represents a short-circuiting logical OR of this predicate and another.
 */
public class PredicateExampleOr
{
    public static void main(String[] args)
    {
        Predicate<Integer> isOne = num -> num == 1;
        Predicate<Integer> isFour = num -> num == 4;

        System.out.println("Example #1: OR ->" + isFour.or(isOne).test(4) + "\n");

        List<Integer> result = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
                .filter(isOne.or(isFour))
                .collect(Collectors.toList());
        System.out.println("Example #2: OR -> "+ result);
    }
}
