package com.malex.lecture_1_primitive.example_1;

import lombok.extern.java.Log;


@Log
public class App_2 {

    public static void main(String[] args) {
        int a = 3;
        int b = 5;

        a = a ^ b;
        log.info("a - " + a);
        b = a ^ b;
        log.info("b - " + b);
        a = a ^ b;
        log.info("a - " + a);
        log.info("a = " + a);
        log.info("b = " + b);
    }
}
