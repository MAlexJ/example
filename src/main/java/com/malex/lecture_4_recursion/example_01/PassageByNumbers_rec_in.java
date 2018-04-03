package com.malex.lecture_4_recursion.example_01;

public class PassageByNumbers_rec_in {

    public static void main(String[] args) {
        f(1);
    }

    public static void f(int arg) {
        System.out.print(" " + arg);
        if (arg < 7) {
            f(2 * arg);
        }
    }

}
