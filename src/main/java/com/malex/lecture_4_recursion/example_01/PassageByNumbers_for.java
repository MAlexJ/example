package com.malex.lecture_4_recursion.example_01;

public class PassageByNumbers_for {

    public static void main(String[] args) {

        // task: 1 2 4 8 16 32 64 128
        // amount of numbers
        int n = 4;
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result = 1;
                System.out.print(result + " ");
            } else {
                result = result * 2;
                System.out.print(result + " ");
            }
        }
    }
}
