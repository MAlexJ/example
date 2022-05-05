package com.malex.lecture_15_Lambda.example_01;

import lombok.extern.java.Log;

/**
 * Simple example lambda and local variable.
 * Use class-level variables:
 */
@Log
public class SimpleExampleLambdaLocalVariable {

    //use class-level variables:
    private static int x = 10;
    private static int y = 20;

    public static void main(String[] args) {

        // use class-level variables:
        log.info("Before, x= " + x); // 30 - значение x изменилось
        Operation op = () -> {
            x = 30;
            return x + y;
        };
        log.info("Lambda -> calculate = " + op.calculate()); // 50
        log.info("After, x= " + x + "\n"); // 30 - значение x изменилось


        // local method-level variables:
        int a = 12;
        int b = 7;
        log.info("Before, a= " + a);
        op = () -> {
            //  a=100; // - так нельзя сделать
            return a + b;
        };
        // a=100; // - так тоже нельзя
        log.info("op.calculate() = " + op.calculate() + "\n"); // 100
        log.info("After, a= " + a);

        //Blocks of code in lambda expressions
        Lambda labmda = (x, y) -> {
            if (x == 0)
                return 0;
            else {
                return x / y;
            }
        };
        log.info("labmda.calculate(0, 20) = " + labmda.calculate(0, 20)); // 100
        log.info("labmda.calculate(50, 20) = " + labmda.calculate(50, 20)); // 100
    }
}

/**
 * Functional interface
 */
interface Operation {
    int calculate();
}

interface Lambda {
    int calculate(int x, int y);
}