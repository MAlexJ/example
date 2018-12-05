package com.malex.lecture_15_CompletableFuture.combiningFutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import lombok.extern.log4j.Log4j;

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
   * Notice that this method takes a function that returns a CompletableFuture instance. The
   * argument of this function is the result of the previous computation step. This allows us to use
   * this value inside the next CompletableFuture‘s lambda:
   */
  private static void chainTwoFuturesSequentially()
      throws ExecutionException, InterruptedException {

    CompletableFuture<String> cFuture =
        CompletableFuture.supplyAsync(() -> "Hello").thenCompose(getResource());

    log.debug(cFuture.get());
  }

  private static Function<String, CompletionStage<String>> getResource() {
    return future -> CompletableFuture.supplyAsync(() -> future + "!");
  }
}
