package com.malex.lecture_16_Exception.exception_examples;

/**
 * Created by Alex on 4/18/2015.
 */
public class ClassCastExceptionExample {

    public static void main(String[] args) {
        Object ref = new int[1];
        String str = (String) ref;
        //        int[] intArr = (int[]) ref;
    }
}
