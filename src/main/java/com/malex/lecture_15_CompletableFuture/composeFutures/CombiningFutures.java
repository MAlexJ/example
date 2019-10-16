package com.malex.lecture_15_CompletableFuture.composeFutures;

import lombok.extern.log4j.Log4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

/**
 * The best part of the CompletableFuture API is the ability to combine CompletableFuture instances
 * in a chain of computation steps.
 */
@Log4j
public class CombiningFutures {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // #1 chain two Futures sequentially
        chainTwoFuturesSequentially();
    }

    /**
     * In the following example we use the thenCompose method to chain two Futures sequentially.
     * Notice that this method takes a function that returns a CompletableFuture instance.
     * The argument of this function is the result of the previous computation step. This allows us to use
     * this value inside the next CompletableFuture‘s lambda:
     */
    private static void chainTwoFuturesSequentially()
            throws ExecutionException, InterruptedException {

        CompletableFuture<String> cFuture = createCompletableFuture()
                .thenCompose(applyString(" one,"))
                .thenCompose(applyString(" two,"))
                .thenCompose(applyString(" tree"))
                .thenCompose(applyEnd());

        log.debug(cFuture.get());
    }

    private static Function<String, CompletionStage<String>> applyString(String msg) {
        return future -> CompletableFuture.supplyAsync(() -> future + msg);
    }

    private static CompletableFuture<String> createCompletableFuture() {
        return CompletableFuture.supplyAsync(() -> "Hello");
    }

    private static Function<String, CompletionStage<String>> applyEnd() {
        return future -> CompletableFuture.supplyAsync(() -> future + "!");
    }
}
