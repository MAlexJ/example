package com.malex.lecture_15_Lambda.example_02;

import lombok.extern.java.Log;

/**
 * Lambdas passed as parameters to methods.
 *
 * @author malex
 */
@Log
public class LambdasPassedParamToMethods {

    public static void main(String[] args) {
        Expression exp = n -> (n % 2 == 0);

        int sum = sum(exp, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        log.info("Result of calculation: " + sum);
    }

    /**
     * Sum numbers.
     *
     * @param numbers array of number
     * @param func    functional interface
     * @return the result of the calculation.
     */
    private static int sum(Expression func, int... numbers) {
        int result = 0;
        for (int i : numbers) {
            if (func.isEqual(i))
                result += i;
        }
        return result;
    }
}

/**
 * Functional interface
 */
interface Expression {
    boolean isEqual(int n);
}
