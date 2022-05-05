package com.malex.lecture_15_Lambda.example_01;

import lombok.extern.java.Log;

/**
 * Simple example generalized functional interface.
 */
@Log
public class SimpleExampleGeneralizedFunctionalInterface {

    public static void main(String[] args) {

        LambdaInterface<Integer> lmbInteger = (x, y) -> {
            if (x > y)
                return x + y;
            else
                return x - y;
        };

        LambdaInterface<String> lmbString = (x, y) -> {
            if (x.isEmpty() || y.isEmpty()) {
                return "Result empty!";
            }
            return x + y;
        };

        log.info("Result: " + lmbInteger.calculate(12, 14));
        log.info("Result: " + lmbString.calculate("start_", "finish"));

    }
}

/**
 * Generalized functional interface.
 *
 * @param <T> functional interface
 */
interface LambdaInterface<T> {
    T calculate(T x, T y);
}
