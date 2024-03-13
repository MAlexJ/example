package com.malex.lecture_15_concurrency.lock.ReentrantLock;

import com.malex.utils.AbstractUtils;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.SneakyThrows;
import org.junit.Test;

public class TryToLock extends AbstractUtils {

  private static final Lock lock = new ReentrantLock();

  @Test
  public void tryLockSample() {
    var work = new WorkThread();

    var thread =
        new Thread(
            () -> {
              String threadName = Thread.currentThread().getName();
              print(threadName, "begin work");
              while (true) {
                // Returns: true if the lock was acquired and false otherwise
                if (lock.tryLock()) {
                  print(threadName, "HARD WORK!");
                  break;
                } else {
                  println(threadName, ">", "perform alternative actions");
                }
                sleepInMillis(100);
              }
            });

    startAllThread(work, thread);
    joinAllThreadToMain(work, thread);
  }

  private static class WorkThread extends Thread {

    @SneakyThrows
    @Override
    public void run() {
      lock.lock();
      printlnString(getName(), "start working");
      sleep(500);
      printlnString(getName(), "stop working");
      lock.unlock();
      printlnString(getName(), "lock is released");
    }
  }
}
