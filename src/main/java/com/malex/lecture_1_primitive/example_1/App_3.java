package com.malex.lecture_1_primitive.example_1;

import lombok.extern.java.Log;

/**
 * Created by admin on 29.01.2015.
 */
@Log
public class App_3 {

    public static void main(String[] args) {
        int a = 1_500_000_000;
        int b = 1_600_000_000;

        a = a + b; // a = -1_194_967_296, b = 1_600_000_000
        b = a - b; // a = -1_194_967_296, b = 1_500_000_000
        a = a - b; // a = 1_600_000_000, b = 1_500_000_000

        log.info("a = " + a);
        log.info("b = " + b);
    }
}
