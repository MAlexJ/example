package com.malex.lecture_16_Exception.example_02_exeption_syntax;

import lombok.extern.java.Log;

@Log
public class TestNoLocal {

    public static void main(String[] args) {

        log.info("#1.in");
        f(); //
        log.info("#1.out");
    }

    public static void f() {
        log.info(".   #2.in");
        g();
        log.info(".   #2.out");
    }

    private static void g() {
        log.info(".   .   #3.in");
        h();
        log.info(".   .   #3.out");
    }

    public static void h() {
        log.info(".   .   .   #4.in");
        if (true) {
            log.info(".   .   .   #4.RETURN");
            return;
        }
        log.info(".   .   .   #4.out");
    }
}