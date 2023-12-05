package com.malex.lecture_2_statements.ExpressionStatements.lecture_2_min_element;

public class Solution_2 {
    public static int num1;
    public static int num2;

    public static void main(String[] args) {
        System.out.println(minNumber(20, -1, 1, 18));
        System.out.println(minNumber(0, 0, 0, 0));
        System.out.println(minNumber(1, -2, 10, 2));
        System.out.println(minNumber(-5, 2, -1, 5));
        System.out.println(minNumber(-5, 2, -1, -5));
        System.out.println(minNumber(5, 2, 10, 5));
    }

    public static int minNumber(int a, int b, int c, int d) {
        if (a + b < c + d) {
            num1 = a;
            num2 = b;
        } else {
            num1 = c;
            num2 = d;
        }

        if (a + b == c + d) {
            if (a < c) {
                num1 = a;
            } else {
                num1 = c;
            }
            if (b < d) {
                num2 = b;
            } else {
                num2 = d;
            }
        }

        if (num1 < num2) {
            return num1;
        }
        return num2;
    }
}
