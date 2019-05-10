package com.malex.lecture_25_Java_8_Futures.example_01_CompletableFuture;

import lombok.extern.log4j.Log4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Log4j
public class SimpleExampleGetResult {

    public static void main(String[] args) throws Exception {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                log.info(">>> wait");
                Thread.sleep(1500);
                log.info(" >>> continue");
            } catch (Exception ex) {
                log.error(ex.getMessage());
            }
            return "Hi!";
        });

        log.debug("Result: " + future.get(2, TimeUnit.SECONDS));
    }
}
