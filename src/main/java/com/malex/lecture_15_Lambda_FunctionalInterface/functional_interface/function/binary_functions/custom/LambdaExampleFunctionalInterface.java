package com.malex.lecture_15_Lambda_FunctionalInterface.functional_interface.function.binary_functions.custom;

/**
 * Simple example of using lambda expressions.
 */
class LambdaExampleFunctionalInterface {

    public static void main(String[] args) {
        OperationFunction operation = Integer::sum;
        OperationFunction.print(operation.calculate(2, 4));

        OperationFunction operation1 = (int x, int y) -> x / y;
        OperationFunction operation2 = (int x, int y) -> x - y;
        OperationFunction operation3 = (int x, int y) -> x * y;

        OperationFunction.print(operation1.calculate(10, 4));
        OperationFunction.print(operation2.calculate(2, 4));
        OperationFunction.print(operation3.calculate(2, 4));
    }
}

/**
 * Functional interface.
 */
interface OperationFunction {

    /**
     * Functional interface must contain only a single method with no implementation.
     */
    int calculate(int x, int y);

    static void print(int result) {
        System.out.println("result: " + result);
    }
}
