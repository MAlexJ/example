package com.malex.lecture_15_Lambda.example_02;

import lombok.extern.java.Log;

/**
 * References to the method as the method parameters
 */
@Log
public class ReferencesToMethodAsMethodParameters {

    public static void main(String[] args) {
        int[] nums = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};

        Expression expr = ExpressionHelper::isEven;
        log.info("sum: " + sum(nums, expr));

        // Link to the method passed in the form class_name :: name_static_method
        // or object_class :: method_name (if the method is non-static)
        expr = ExpressionHelper::isPositive;
        // Example: References to the method as the method parameters

        log.info(sum(nums, expr) + "\n");

        //object_class :: method_name (if the method is non-static)
        expr = new ExpressionNewHelper()::isEquals;
        log.info("sum: " + sum(nums, expr));
    }

    private static int sum(int[] numbers, Expression func) {
        int result = 0;
        for (int i : numbers) {
            if (func.isEqual(i)) result += i;
        }
        return result;
    }
}

/**
 * Class with static method
 */
class ExpressionHelper {

    private ExpressionHelper() {
        //non use
    }

    static boolean isEven(int n) {
        return n % 2 == 0;
    }

    static boolean isPositive(int n) {
        return n > 0;
    }
}

/**
 * Class with non static method
 */
class ExpressionNewHelper {

    boolean isEquals(int n) {
        int x = 5;
        return n == x;
    }
}