package com.malex.lecture_15_concurrency.atomic.atomic_reference.usage;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.Test;

public class Cache_for_single_element extends AbstractUtils {

  private static final AtomicReference<ValueREfs> ATOMIC_REFERENCE = new AtomicReference<>();

  private static final Integer COUNT = 10_000_000;

  public Cache_for_single_element() {
    ATOMIC_REFERENCE.set(new ValueREfs());
  }

  @Test
  public void cache_read_only() {
    ATOMIC_REFERENCE.getAndUpdate(
        valueREfs -> {
          valueREfs.increment();
          return valueREfs;
        });
    try (ExecutorService executorService = Executors.newFixedThreadPool(10)) {
      for (int i = 0; i < COUNT; i++) {
        executorService.submit(
            () -> {
              ValueREfs valueREfs = ATOMIC_REFERENCE.get();
              println("valueREfs: " + valueREfs.getValue());
            });
      }
      executorService.shutdown();
    }
  }

  @Test
  public void cache_with_update() {
    long start = System.nanoTime();
    try (ExecutorService executorService = Executors.newFixedThreadPool(10)) {
      for (int i = 0; i < COUNT; i++) {
        executorService.submit(
            () -> {
              ATOMIC_REFERENCE.getAndUpdate(
                  valueREfs -> {
                    valueREfs.increment();
                    return valueREfs;
                  });
            });
      }
      executorService.shutdown();
    } finally {
      assertEquals(COUNT, ATOMIC_REFERENCE.get().getValue());
      println("Time:", +(System.nanoTime() - start) / 1_000_000.0, "ms");
    }
  }

  private static class ValueREfs {

    private Integer value;

    private ValueREfs() {
      this.value = 0;
    }

    public synchronized Integer getValue() {
      return value;
    }

    public synchronized void increment() {
      this.value = value + 1;
    }
  }
}
