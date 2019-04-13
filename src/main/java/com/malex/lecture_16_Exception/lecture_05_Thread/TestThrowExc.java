package com.malex.lecture_16_Exception.lecture_05_Thread;

import lombok.extern.log4j.Log4j;

/**
 * Created by root on 27.06.15.
 */
@Log4j
public class TestThrowExc {

    public static void main(String[] args) throws Exception {

        Thread thread0 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                log.debug(" ->>>> j= " + i + " " + Thread.currentThread().getName());
                if (i == 5) {
                    throw new RuntimeException();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    log.error(e);
                }
            }
        });

        thread0.start();

        for (int i = 0; i < 10; i++) {
            log.debug(" * i= " + i + " " + Thread.currentThread().getName());
            Thread.sleep(500);
        }

        log.debug("Exit main");
    }
}
