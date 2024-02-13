package com.malex.lecture_15_concurrency.example_07_atomic.samples;

import com.malex.utils.AbstractUtils;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.SneakyThrows;

public class ChestAtomic extends AbstractUtils {

  private final AtomicInteger atomicInteger = new AtomicInteger();

  public ChestAtomic(int money) {
    this.atomicInteger.set(money);
  }

  @SneakyThrows
  public void withdraw(int amount, Player player) {
    int currentValue = atomicInteger.get();
    if (amount < 0 || currentValue <= amount) {
      println("Player", player.name(), "can't withdraw!", "Not enough gold!");
      return;
    }
    TimeUnit.MILLISECONDS.sleep(2);
    println("Withdraw :", amount, "by player", player.name());
    atomicInteger.set(currentValue - amount);
  }

  public int info() {
    println("Chest gold :", atomicInteger.get(), "\n");
    return atomicInteger.get();
  }
}
