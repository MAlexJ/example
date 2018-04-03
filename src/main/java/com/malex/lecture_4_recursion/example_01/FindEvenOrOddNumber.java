package com.malex.lecture_4_recursion.example_01;

public class FindEvenOrOddNumber {

    public static void main(String[] args) {
        System.out.println("Number: 10 is odd: " + isOdd(1));
        System.out.println("Number: 10 is even: " + isEven(1));
    }

    private static boolean isEven(int k) {
        return k == 0 || isOdd(k - 1);
    }

    private static boolean isOdd(int k) {
        return k != 0 && isEven(k - 1);
    }
}

