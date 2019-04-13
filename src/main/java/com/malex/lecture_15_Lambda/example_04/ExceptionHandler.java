package com.malex.lecture_15_Lambda.example_04;

import lombok.extern.log4j.Log4j;

@Log4j
public class ExceptionHandler {

    public static void main(String[] args) {

        exceptionHandler(() -> {
            log.debug("consumer 1");

            exceptionHandler(() -> {
                log.debug("consumer 2");

                exceptionHandler(() -> {
                    log.debug("consumer 3");
                    throw new RuntimeException();
                }, "Error msg 3");

            }, "Error msg 2");

        }, "Error msg 1");

    }

    private static void exceptionHandler(Runnable r, String errMsg) {
        try {
            r.run();
        } catch (Exception ex) {
            // close tx or something else
            log.error(errMsg + " " + ex);
        }
    }
}
