package com.malex.lecture_16_Exception.example_02_exeption_syntax;

import lombok.extern.log4j.Log4j;

@Log4j
public class TestNoLocal {
   
    public static void main(String[] args) {

        log.error("#1.in");
        f(); //
        log.error("#1.out");
    }

    public static void f() {
        log.error(".   #2.in");
        g();
        log.error(".   #2.out");
    }

    private static void g() {
        log.error(".   .   #3.in");
        h();
        log.error(".   .   #3.out");
    }

    public static void h() {
        log.error(".   .   .   #4.in");
        if (true) {
            log.error(".   .   .   #4.RETURN");
            return;
        }
        log.error(".   .   .   #4.out");
    }
}
