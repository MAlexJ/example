package com.malex.lecture_1_primitive;


import lombok.extern.java.Log;

/**
 * Created by MAlex on 1/30/2015.
 */
@Log
public class DivisionByZeroSample {
    public static void main(String[] args) {
        log.info("main");

        log.info("int a=0 / int b=2: " + 0 / 2);

        /*
        Exception java.lang.ArithmeticException: / by zero
        LOG.info("int a=2 / int b=0: "+ 2/0);
        This result -> Infinity
        */

        log.info("float a=2f / int b=0: " + 2f / 0);

        /* This result -> Infinity */
        log.info("double t a=2d / int b=0: " + 2d / 0);

        /* This result -> 0.0 */
        log.info("int b=0 /double t a=2d " + 0 / 2d);

        /* This result -> NaN */
        log.info("double t a=0d / int b=0: " + 0d / 0);
    }
}
