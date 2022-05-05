package com.malex.lecture_1_primitive.example_1;

import lombok.extern.java.Log;

@Log
public class App_1 {

    public static void main(String[] args) {
        int a = 3;
        int b = 5;

        a = a + b; // a = 8, b = 5
        b = a - b; // a = 8, b = 3
        a = a - b; // a = 5, b = 3

        log.info("a = " + a);
        log.info("b = " + b);
    }
}
