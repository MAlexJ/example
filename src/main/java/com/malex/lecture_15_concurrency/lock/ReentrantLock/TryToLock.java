package com.malex.lecture_15_concurrency.lock.ReentrantLock;

import static com.malex.utils.AbstractUtils.sleepInMillisStatic;

import com.malex.lecture_15_concurrency.AbstractThreadUtils;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.Test;

public class TryToLock extends AbstractThreadUtils {

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
                  print(threadName, ">", "perform alternative actions");
                }
                sleepInMillis(100);
              }
            });

    startAllThread(work, thread);
    joinAllThreadToMain(work, thread);
  }

  private static class WorkThread extends Thread {

    @Override
    public void run() {
      lock.lock();
      print(getName(), "start working");
      sleepInMillisStatic(500);
      print(getName(), "stop working");
      lock.unlock();
      print(getName(), "lock is released");
    }
  }
}
