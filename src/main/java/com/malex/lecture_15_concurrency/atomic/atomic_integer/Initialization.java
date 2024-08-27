package com.malex.lecture_15_concurrency.atomic.atomic_integer;

import com.malex.lecture_15_concurrency.AbstractThreadUtils;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

public class Initialization extends AbstractThreadUtils {

  @Test
  public void init() {
    // 1. Creates a new AtomicInteger with initial value 0
    AtomicInteger atomicInteger = new AtomicInteger();
    print("Initializing atomic integer", atomicInteger.get());


    // 2. Creates a new AtomicInteger with the given initial value.
    atomicInteger = new AtomicInteger(-3);
    print("Initializing atomic integer with initial value", atomicInteger.get());
  }
}
