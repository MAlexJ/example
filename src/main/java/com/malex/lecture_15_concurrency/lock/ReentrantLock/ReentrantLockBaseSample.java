package com.malex.lecture_15_concurrency.lock.ReentrantLock;

import static junit.framework.TestCase.assertEquals;

import com.malex.utils.AbstractUtils;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.Getter;
import org.junit.Test;

/**
 * ReentrantLock
 *
 * <p>tutorial: <a href="https://www.youtube.com/watch?v=2OnAxdxtNmw">ReentrantLock</a>
 */
public class ReentrantLockBaseSample extends AbstractUtils {

  @Test
  public void runSimpleExample() {
    // given
    var resource = new MyResource(5);

    // when
    var first =
        new Thread(
            () -> {
              for (int i = 0; i < 100000; i++) resource.changeNum();
            });
    first.setName("First");
    var second =
        new Thread(
            () -> {
              for (int i = 0; i < 100000; i++) resource.changeNum();
            });
    startAllThread(first, second);
    joinAllThreadToMain(first, second);

    // then
    println("num:", resource.getNum());
    assertEquals(200005, resource.getNum());
  }

  @Test
  public void run() {
    // given
    var resource = new TwoResource(5, 7);

    // when
    var first =
        new Thread(
            () -> {
              for (int i = 0; i < 100000; i++) resource.changeNum();
            });
    first.setName("TwoResource");
    var second =
        new Thread(
            () -> {
              for (int i = 0; i < 100000; i++) resource.changeNum();
            });
    startAllThread(first, second);
    joinAllThreadToMain(first, second);

    // then
    println("one:", resource.getOne(), ", two:", resource.getTwo());
    assertEquals(200005, resource.getOne());
    assertEquals(200007, resource.getTwo());
  }

  private static class MyResource {
    private final Lock lock = new ReentrantLock();

    @Getter private int num;

    public MyResource(int num) {
      this.num = num;
    }

    void changeNum() {
      lock.lock();
      try {
        int i = this.num;
        if (Thread.currentThread().getName().equals("First")) {
          Thread.yield();
        }
        i++;
        this.num = i;
      } finally {
        lock.unlock();
      }
    }
  }

  @Getter
  private static class TwoResource {
    private final Lock lock = new ReentrantLock();

    private int one;
    private int two;

    TwoResource(int one, int two) {
      this.one = one;
      this.two = two;
    }

    public void changeNum() {
      changeOne(); // >>> lock
      changeTwo(); // <<< unlock
    }

    private void changeOne() {
      // >>> lock
      lock.lock();
      int i = this.one;
      if (Thread.currentThread().getName().equals("TwoResource")) {
        Thread.yield();
      }
      i++;
      this.one = i;
    }

    private void changeTwo() {
      int j = this.two;
      if (Thread.currentThread().getName().equals("TwoResource")) {
        Thread.yield();
      }
      j++;
      this.two = j;
      // <<< unlock
      lock.unlock();
    }
  }
}
