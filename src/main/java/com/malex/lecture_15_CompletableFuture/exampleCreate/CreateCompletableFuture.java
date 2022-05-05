package com.malex.lecture_15_CompletableFuture.exampleCreate;

import lombok.extern.java.Log;

import java.util.concurrent.*;
import java.util.function.Supplier;

@Log
public class CreateCompletableFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        /*
         * #1. Returns a new CompletableFuture that is already completed with * the given value
         */
        CompletableFuture<Long> fLong = CompletableFuture.completedFuture(42L);
        Long vLong = fLong.get(100, TimeUnit.SECONDS);
        log.info(vLong.toString());

        /*
         * #2. Returns a new CompletableFuture that is asynchronously completed
         * by a task running in the {@link ForkJoinPool#commonPool()} after
         * it runs the given action.
         */
        CompletableFuture<Void> voidRunAsync = CompletableFuture.runAsync(getRunnable());
        voidRunAsync.get();

        /*
         * #3. Returns a new CompletableFuture that is asynchronously completed
         * by a task running in the {@link ForkJoinPool#commonPool()} with
         * the value obtained by calling the given Supplier.
         */
        CompletableFuture<Integer> intSupplyAsync = CompletableFuture.supplyAsync(getSupplier());
        Integer result = intSupplyAsync.get();
        log.info(result.toString());

        /*
         * #4. Using CompletableFuture as a Simple Future
         */
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        Future<String> stringFuture = calculateAsync(completableFuture);
        log.info(stringFuture.get());
    }

    private static Future<String> calculateAsync(CompletableFuture<String> completableFuture) {
        Executors.newCachedThreadPool().submit(() -> {
            completableFuture.complete("Hello");
            return null;
        });

        return completableFuture;
    }

    private static Supplier<Integer> getSupplier() {
        return () -> Math.abs(10);
    }

    private static Runnable getRunnable() {
        return () -> {
            int min = Math.min(12, 67);
            log.info("" + min);
        };
    }
}
