package com.malex.lecture_15_Lambda.supplier;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.junit.Test;

public class SupplierLazyInitialization {

  @Test
  public void lazyInitializationSupplier() {
    Supplier<List<Integer>> lazySupplier = ArrayList::new;
    List<Integer> numbers = lazySupplier.get();
    numbers.add(1);
    numbers.add(10);
    assertNotNull(numbers);
  }

  /** Optional.orElseGet(Supplier<? extends T> supplier) */
  @Test
  public void optionalOrElseGet() {
    var phrases = List.of("alex", "cat", "text");
    var searchResult =
        phrases.stream()
            .filter(phrase -> phrase.startsWith("Not"))
            .findFirst()
            .orElseGet(() -> "Not found!");

    assertEquals("Not found!", searchResult);
  }
}
