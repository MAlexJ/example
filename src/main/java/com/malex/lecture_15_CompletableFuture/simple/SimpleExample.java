package com.malex.lecture_15_CompletableFuture.simple;

import lombok.extern.log4j.Log4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Log4j
public class SimpleExample
{

    public static void main(String[] args) throws Exception
    {

        /*
         * Returns a new CompletableFuture that is asynchronously completed
         * by a task running in the {@link ForkJoinPool#commonPool()} with
         * the value obtained by calling the given Supplier.
         */
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hi");
        log.debug(future.get());

        future = CompletableFuture
                .supplyAsync(() -> "Bye!", Executors.newCachedThreadPool());
        log.debug(future.get());

        /*
         *Returns a new CompletableFuture that is asynchronously completed
         * by a task running in the {@link ForkJoinPool#commonPool()} after
         * it runs the given action.
         */
        CompletableFuture<Void> futureAsync = CompletableFuture.runAsync(() -> log.debug("Hi!"));
        log.debug(futureAsync.get(1, TimeUnit.SECONDS));

        futureAsync = CompletableFuture
                .runAsync(() -> log.debug("Bye!"), Executors.newCachedThreadPool());
        log.debug(futureAsync.get(1, TimeUnit.SECONDS));

        if (futureAsync.isDone())
        {
            System.exit(0);
        }
    }
}
