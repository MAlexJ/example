package com.malex.lecture_15_concurrency.lock.ReentrantLock;

import com.malex.lecture_15_concurrency.AbstractThreadUtils;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.Test;

public class ReentrantLock_simple extends AbstractThreadUtils {

  private final ReentrantLock lock = new ReentrantLock();

  @Test
  public void sample() {
    try {

      // given
      printLockInfo(
          () -> {
            lock.lock();
            lock.lock();
          });

      // then
      printLockInfo(lock::unlock);
    } finally {

      // and
      printLockInfo(lock::unlock);
    }
  }

  private void printLockInfo(Runnable r) {
    var threadName = getThreadName();

    r.run();

    /*
     * Queries if this lock is held by any thread
     */
    print("Thread %s, lock.isLocked(): %s".formatted(threadName, lock.isLocked()));

    /*
     * Queries the number of holds on this lock by the current thread
     */
    print("Thread %s, lock.getHoldCount(): %s".formatted(threadName, lock.getHoldCount()));

    /*
     * Queries if this lock is held by the current thread
     */
    print(
        "Thread %s, lock.isHeldByCurrentThread(): %s"
            .formatted(threadName, lock.isHeldByCurrentThread()));

    /*
     * Returns true if this lock has fairness set true
     */
    print("Thread %s, lock.isFair(): %s".formatted(threadName, lock.isFair()), " \n");
  }
}
