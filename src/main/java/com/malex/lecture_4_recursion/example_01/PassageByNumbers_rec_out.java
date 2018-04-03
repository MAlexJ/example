package com.malex.lecture_4_recursion.example_01;

/**
 * Created by Alex on 13.06.2015.
 */
public class PassageByNumbers_rec_out {

    public static void main(String[] args) {
        f(1);
    }

    public static void f(int arg) {

        if (arg < 7) {
            f(2 * arg);
        }
        System.out.print(" " + arg);
    }
}
