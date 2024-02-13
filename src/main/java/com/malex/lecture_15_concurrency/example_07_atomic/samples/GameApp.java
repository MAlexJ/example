package com.malex.lecture_15_concurrency.example_07_atomic.samples;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;

public class GameApp extends AbstractUtils {

  private final Player player1 = new Player("Anna");
  private final Player player2 = new Player("Max");
  private final Player player3 = new Player("Stefan");

  private Chest chest;

  @Before
  public void before() {
    chest = new Chest(100);
  }

  @Test
  public void launch() {
    var t1 = new Thread(() -> chest.withdrawNoneSync(50, player1));
    var t2 = new Thread(() -> chest.withdrawNoneSync(50, player2));
    var t3 = new Thread(() -> chest.withdrawNoneSync(50, player3));
    runThreads(t1, t2, t3);
    // Note: results are not known
    chest.info();
  }

  @Test
  public void launchAtomic() {
    var chestAtomic = new ChestAtomic(100);
    var thread1 = new Thread(() -> chestAtomic.withdraw(50, player1));
    var thread2 = new Thread(() -> chestAtomic.withdraw(50, player2));
    var thread3 = new Thread(() -> chestAtomic.withdraw(50, player3));
    runThreads(thread1, thread2, thread3);
    // Note: results are not known
    chest.info();
  }

  @Test
  public void launchWIthSync() {
    var t1 = new Thread(() -> chest.withdrawSync(50, player1));
    var t2 = new Thread(() -> chest.withdrawSync(50, player2));
    var t3 = new Thread(() -> chest.withdrawSync(50, player3));
    runThreads(t1, t2, t3);
    assertEquals(0, chest.info());
  }

  @SneakyThrows
  private void runThreads(Thread... threads) {
    for (var thread : threads) {
      thread.start();
    }
    for (var thread : threads) {
      thread.join();
    }
  }

  @Test
  public void test() {
    assertEquals(50, chest.withdraw(50, player1));
    assertEquals(40, chest.withdraw(10, player1));
    assertEquals(10, chest.withdraw(30, player1));
    assertEquals(0, chest.withdraw(10, player1));
    assertEquals(0, chest.withdraw(10, player1));
    assertEquals(0, chest.withdraw(-10, player1));
  }
}
