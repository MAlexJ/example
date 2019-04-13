package com.malex.lecture_15_Lambda.example_01;

/**
 * Simple example of using terminal lambda expression
 *
 * @author malex
 */
public class SimpleExampleTerminalExpression {
    public static void main(String[] args) {
        Lambdable lamb = System.out::println;
        lamb.print("Hello!");
    }
}

/**
 * Functional interface
 */
interface Lambdable {

    /**
     * Functional interface must contain only a single method with no implementation.
     *
     * @param str the incoming value.
     */
    void print(String str);
}
