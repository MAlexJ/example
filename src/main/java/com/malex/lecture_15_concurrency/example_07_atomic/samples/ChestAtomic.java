package com.malex.lecture_15_concurrency.example_07_atomic.samples;

import com.malex.utils.AbstractUtils;
import java.util.concurrent.atomic.AtomicInteger;

public class ChestAtomic extends AbstractUtils {

  private final AtomicInteger atomicInteger = new AtomicInteger();

  public ChestAtomic(int money) {
    this.atomicInteger.set(money);
  }

  public void withdraw(int amount, Player player) {}

  public int info() {
    println("Chest gold :", atomicInteger.get());
    return atomicInteger.get();
  }
}
