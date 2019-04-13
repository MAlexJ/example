package com.malex.lecture_16_Exception.example_02_exeption_syntax;

import lombok.extern.log4j.Log4j;

@Log4j
public class TestTryCatch {

    public static void main(String[] args) {
        try {
            log.error(" 0");
            if (true) {
                throw new RuntimeException();
            }
            log.error(" 1");
        } catch (Exception e) {
            log.error(" 2");
        }
        log.error(" 3");
    }
}
