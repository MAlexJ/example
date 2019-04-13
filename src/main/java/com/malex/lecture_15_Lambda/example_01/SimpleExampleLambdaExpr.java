package com.malex.lecture_15_Lambda.example_01;

import lombok.extern.log4j.Log4j;

/**
 * Simple example of using lambda expression.
 * The method of functional interface without parameters.
 *
 * @author malex
 */
@Log4j
public class SimpleExampleLambdaExpr {

    public static void main(String[] args) {

        Operationable operation = () -> 20 + 40;
        log.debug(" () -> 20 + 40;  \n result: " + operation.method());

        Exampleable lamb1 = (x) -> x + 2;
        log.debug(" (x) -> x + 2;  \n result: " + lamb1.method(2));

        Exampleable lamb2 = x -> x * 3;
        log.debug(" x -> x * 3;  \n result: " + lamb2.method(2));
    }
}

/**
 * Functional interface.
 */
interface Operationable {

    /**
     * Method without parameters.
     *
     * @return result
     */
    int method();
}

/**
 * Functional interface.
 */
interface Exampleable {

    /**
     * Method has one parameter.
     *
     * @param x input value.
     * @return result calculation.
     */
    int method(int x);
}
