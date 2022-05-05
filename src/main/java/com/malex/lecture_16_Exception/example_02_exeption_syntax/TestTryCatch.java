package com.malex.lecture_16_Exception.example_02_exeption_syntax;

import lombok.extern.java.Log;

@Log
public class TestTryCatch {

    public static void main(String[] args) {
        try {
            log.info(" 0");
            if (true) {
                throw new RuntimeException();
            }
            log.info(" 1");
        } catch (Exception e) {
            log.info(" 2");
        }
        log.info(" 3");
    }
}
