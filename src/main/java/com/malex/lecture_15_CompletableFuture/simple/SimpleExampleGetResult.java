package com.malex.lecture_15_CompletableFuture.simple;

import lombok.extern.java.Log;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Log
public class SimpleExampleGetResult {

    public static void main(String[] args) throws Exception {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                log.info(">>> wait");
                Thread.sleep(1500);
                log.info(" >>> continue");
            } catch (Exception ex) {
                log.severe(ex.getMessage());
            }
            return "Hi!";
        });

        log.info("Result: " + future.get(2, TimeUnit.SECONDS));
    }
}
