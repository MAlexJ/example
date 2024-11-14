package com.malex.lecture_15_concurrency.atomic.atomic_integer.samples;

import com.malex.utils.AbstractUtils;

public class Chest extends AbstractUtils {
  private int money;

  public Chest(int money) {
    this.money = money;
  }

  public synchronized void withdrawSync(int amount, Player player) {
    withdraw(amount, player);
  }

  public void withdrawNoneSync(int amount, Player player) {
    withdraw(amount, player);
  }

  public int withdraw(int amount, Player player) {
    if (amount < 0 || this.money < amount) {
      println("Player", player.name(), "can't withdraw!", "Not enough gold!");
      return this.money;
    }

    sleepInMillisStatic(2);
    println("Withdraw :", amount, "by player", player.name());

    this.money -= amount;
    return this.money;
  }

  public int info() {
    println("Chest gold :", this.money, "\n");
    return this.money;
  }
}
