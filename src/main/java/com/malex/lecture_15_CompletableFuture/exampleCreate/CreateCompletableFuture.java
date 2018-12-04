package com.malex.lecture_15_CompletableFuture.exampleCreate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Supplier;
import lombok.extern.log4j.Log4j;

@Log4j
public class CreateCompletableFuture {

  public static void main(String[] args)
      throws InterruptedException, ExecutionException, TimeoutException {
    /*
     * #1. Returns a new CompletableFuture that is already completed with * the given value
     */
    CompletableFuture<Long> fLong = CompletableFuture.completedFuture(42L);
    Long vLong = fLong.get(100, TimeUnit.SECONDS);
    log.debug(vLong);

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
    log.debug(result);

    /*
     * #4. Using CompletableFuture as a Simple Future
     */
    CompletableFuture<String> completableFuture = new CompletableFuture<>();
    Future<String> stringFuture = calculateAsync(completableFuture);
    log.debug(stringFuture.get());
  }

  private static Future<String> calculateAsync(CompletableFuture<String> completableFuture) {
    Executors.newCachedThreadPool()
        .submit(
            () -> {
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
      log.debug(min);
    };
  }
}
