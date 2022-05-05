package com.malex.lecture_16_Exception.lecture_05_Thread;

import lombok.extern.java.Log;

/**
 * Created by root on 27.06.15.
 */
@Log
public class TestThrowExc {

    public static void main(String[] args) throws Exception {

        Thread thread0 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                log.info(" ->>>> j= " + i + " " + Thread.currentThread().getName());
                if (i == 5) {
                    throw new RuntimeException();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    log.severe(e.toString());
                }
            }
        });

        thread0.start();

        for (int i = 0; i < 10; i++) {
            log.info(" * i= " + i + " " + Thread.currentThread().getName());
            Thread.sleep(500);
        }

        log.info("Exit main");
    }
}
