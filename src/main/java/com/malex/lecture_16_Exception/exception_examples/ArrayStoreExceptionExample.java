package com.malex.lecture_16_Exception.exception_examples;

/**
 * Created by Alex on 4/18/2015.
 */
public class ArrayStoreExceptionExample {

    public static void main(String[] args) {
        Object[] ref = new Integer[1];
        ref[0] = "Hello!";
    }
}
