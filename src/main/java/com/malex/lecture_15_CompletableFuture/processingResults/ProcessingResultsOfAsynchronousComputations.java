package com.malex.lecture_15_CompletableFuture.processingResults;

import lombok.extern.java.Log;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static junit.framework.TestCase.assertEquals;

@Log
public class ProcessingResultsOfAsynchronousComputations {

    /*
     * Processing Results of Asynchronous Computations
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // #1
        example1();

        // #2
        example2();

        // #3
        example3();
    }

    /**
     * method: thenApply()
     *
     * <p>The most generic way to process the result of a computation is to feed it to a function. The
     * thenApply method does exactly that: accepts a Function instance, uses it to process the result
     * and returns a Future that holds a value returned by a function.
     */
    private static void example1() throws ExecutionException, InterruptedException {

        // sample #1
        CompletableFuture<String> cFuture = CompletableFuture.supplyAsync(() -> "Hi");
        CompletableFuture<String> cFuture1 = cFuture.thenApply(f -> f + " Alex");
        CompletableFuture<String> cFuture2 = cFuture1.thenApply(f -> f + "!");
        assertEquals("Hi Alex!", cFuture2.get());

        // sample 2
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hi").thenApply(f -> f + " ").thenApply(f -> f + "Alex").thenApply(f -> f + "!");
        assertEquals("Hi Alex!", completableFuture.get());
    }

    /**
     * method: thenAccept()
     */
    private static void example2() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> ">>> Hello >>>").thenAccept(s -> log.info("Computation returned: " + s));

        Void aVoid = future.get();
        log.info("" + aVoid);
    }

    /**
     * method: thenRun()
     *
     * <p>if you neither need the value of the computation nor want to return some value at the end of
     * the chain, then you can pass a Runnable lambda to the thenRun method.
     */
    private static void example3() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> "Hello").thenRun(() -> log.info("Computation finished."));

        Void aVoid = future.get();
        log.info("" + aVoid);
    }
}
