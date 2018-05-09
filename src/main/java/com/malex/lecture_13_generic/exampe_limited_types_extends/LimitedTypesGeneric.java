package com.malex.lecture_13_generic.exampe_limited_types_extends;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

import static junit.framework.TestCase.assertTrue;

/**
 * A simple example of using limited types of generic
 */
public class LimitedTypesGeneric
{
    public static void main(String[] args)
    {
        Integer[] arrayFirst = {1, 2, 3, 4, 5};
        Stats<Integer> statsFirst = new Stats<>(arrayFirst);

        Double[] arraySecond = {1.0, 2.0, 3.0, 4.0, 5.0};
        Stats<Double> statsSecond = new Stats<>(arraySecond);

        assertTrue(Objects.equals(statsFirst.average(), statsSecond.average()));
    }

    /**
     * The class contains a limited type of generic as `extends Number`
     */
    @Getter
    @AllArgsConstructor
    private static class Stats<T extends Number>
    {
        private static final double DEFAULT_VALUE = 0;
        private T[] array;

        double average()
        {
            return Arrays.stream(array)
                    .mapToDouble(Number::doubleValue)
                    .average()
                    .orElse(DEFAULT_VALUE);
        }
    }
}
